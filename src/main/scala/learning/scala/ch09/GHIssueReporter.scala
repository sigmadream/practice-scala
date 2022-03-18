package learning.scala.ch09

import org.json4s.*
import org.json4s.jackson.JsonMethods.*

import scala.util.{Failure, Success, Try}

case class GithubUser(login: String)

case class GithubLabel(name: String)

case class GithubIssue(number: Int, title: String, user: GithubUser, labels: List[GithubLabel], comments: Int)

case class FixWidthCol(text: String, width: Int)

case class HttpResponse(lines: List[String], code: Int)


trait JSONSupport {

  import org.json4s.DefaultFormats
  import org.json4s.native.JsonMethods

  implicit val formats: Formats = DefaultFormats

  def parseIssuesFromJson(json: String): List[GithubIssue] = {
    val t = Try(JsonMethods.parse(json).extract[List[GithubIssue]])
    t getOrElse Nil
  }
}

object GHIssueReporter {

  def report(user: String, repo: String, count: Int = 10): Unit = {
    println(s"Creating a report for $user / $repo on $count issues")
    val content: String = HttpSupport.githubClosedIssues(user, repo, count)
    val issues: List[GithubIssue] = GithubIssue.parseIssuesFromJson(content)
    val reportContent = buildReport(issues)
    println(reportContent)
  }

  def buildReport(issues: List[GithubIssue]): String = {
    val issueRows = issues map formatIssue
    val maxLength = issueRows.maxBy(_.size).size
    val border = "=" * maxLength

    val rows = formattedHeader :: border :: issueRows
    rows mkString("\n", "\n", "\n")
  }

  def formatIssue(i: GithubIssue): String = {
    val labelNames = i.labels.map(_.name).mkString(",")
    val fields: List[String] = List(i.number.toString, i.title, i.user.login, i.comments.toString, labelNames)
    val columns = formatFixedWidthColumns(fields)

    columns mkString("|", "|", "|")
  }

  lazy val formattedHeader = {
    val columns = formatFixedWidthColumns(List("Id", "Title", "User", "Comments", "Labels"))
    columns mkString("|", "|", "|")
  }

  def formatFixedWidthColumns(cols: List[String]): List[String] = {
    if (cols.size < 5) cols
    else List(
      f"${cols(0)}%-7.7s",
      f"${cols(1)}%-70.70s",
      f"${cols(2)}%-15.15s",
      f"${cols(3)}%-9.9s",
      f"${cols(4)}%-20.20s"
    )
  }

  def main(args: Array[String]): Unit = {

    val userRepoRegex = """(\w+)/(\w+)""".r
    val numIssuesRegex = """(\d+)""".r

    args.toList match {
      case userRepoRegex(user, repo) :: numIssuesRegex(numIssues) :: Nil =>
        report(user, repo, numIssues.toInt)
      case userRepoRegex(user, repo) :: Nil =>
        report(user, repo)
      case _ =>
        println("Usage: GHIssueReporter user/repo [number of issues]")
    }
  }
}

trait FixedWidthReportSupport {

  def format(cols: List[FixWidthCol], maxWidth: Int): String = {
    val result = cols map format mkString("|", "|", "|")
    result take maxWidth
  }

  def format(col: FixWidthCol): String = {
    val formatting = "%-" + col.width + "." + col.width + "s"
    formatting.format(col.text)
  }

  def formatFixedWidthColumns(cols: List[String]): String = {
    val maxRowWidth = 130

    val fixedWidthColumns = cols zip List(7, 70, 15, 9, 20) map { case (a, b) => FixWidthCol(a, b) }
    format(fixedWidthColumns, maxRowWidth)
  }

}

trait HttpSupport {

  def readUrlAsLines(url: String): HttpResponse = {
    Try(io.Source.fromURL(url).getLines().toList) match {
      case Success(l) => HttpResponse(l, 200)
      case Failure(ex) => HttpResponse(Nil, 400)
    }
  }

  def githubClosedIssues(user: String, repo: String, count: Int): String = {

    val url = s"https://api.github.com/repos/$user/$repo/issues?state=closed&per_page=$count"
    readUrlAsLines(url) match {
      case HttpResponse(lines, code) if code == 200 => lines.map(_.trim).mkString("")
      case HttpResponse(l, code) => {
        println(s"Could not read content from '$url'")
        ""
      }
    }
  }
}

object GithubIssue extends JSONSupport
object HttpSupport extends HttpSupport