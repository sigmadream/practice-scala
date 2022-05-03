package learning.scala.ch09

import com.sangkon.learningscala.ch09.{GHIssueReporter, MultiReplacer, SafeStringUtils}
import org.scalatest.*
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

import java.io.File

class MultiReplacerSpec extends AnyFlatSpec with should.Matchers {

  val content = "Twas brillig, and the slithy toves"

  "The MultiReplacer app" should "replace basic patterns" in {
    val testFile = newFile(content)

    GHIssueReporter.main(Array("brill[^,]*", "the night before xmas", testFile.getName))
    MultiReplacer.read(testFile) should equal("Twas the night before xmas, and the slithy toves")

    GHIssueReporter.main(Array("the slithy.*", "all thru the house", testFile.getName))
    MultiReplacer.read(testFile) should equal("Twas the night before xmas, and all thru the house")
  }

  it should "create a backup file before replacing text" in {
    val testFile = newFile(content)

    GHIssueReporter.main(Array("brill[^,]*", "the night before xmas", testFile.getName))
    MultiReplacer.read(testFile) should equal("Twas the night before xmas, and the slithy toves")

    val backupFile = new File(testFile.getName + ".bak")
    MultiReplacer.read(backupFile) should equal(content)
  }

  it should "create a backup file of any file" in {
    val testFile = newFile(content)
    MultiReplacer.createBackupFile(content, testFile)
    val backupFile = new File(testFile.getName + ".bak")
    MultiReplacer.read(backupFile) should equal(MultiReplacer.read(testFile))
  }

  it should "replace content in a file" in {
    val testFile = newFile(content)
    MultiReplacer.replaceInFile("Twas brilli", "I was sleepin", testFile)
    MultiReplacer.read(testFile) should equal("I was sleeping, and the slithy toves")
  }

  it should "replace content in a series of files by file name" in {
    val testFile1 = newFile(content)
    val testFile2 = newFile(content)
    val files = List(testFile1.getName, testFile2.getName)
    MultiReplacer.replaceInFileNames("Twas", "Twasn't", files)
    MultiReplacer.read(testFile1) should equal("Twasn't brillig, and the slithy toves")
    MultiReplacer.read(testFile2) should equal("Twasn't brillig, and the slithy toves")
  }

  private def newFile(content: String): File = {
    val testFile = new File(s"testy_${SafeStringUtils.randomLetters(20)}.txt")
    MultiReplacer.write(content, testFile)
    testFile
  }
}
