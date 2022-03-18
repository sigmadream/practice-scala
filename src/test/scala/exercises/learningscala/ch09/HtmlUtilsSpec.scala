package exercises.learningscala.ch09

import org.scalatest._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class HtmlUtilsSpec extends AnyFlatSpec with should.Matchers {

  "The Html Utils object" should "remove single elements" in {
    HtmlUtils.removeMarkup("<br/>") should equal("")
  }

  it should "remove paired elements" in {
    HtmlUtils.removeMarkup("<b>Hi</b>") should equal("Hi")
  }

  it should "have no effect on empty strings" in {
    val empty = true
    HtmlUtils.removeMarkup("").isEmpty should equal(empty)
  }

  it should "support multiline tags" in {
    val src =
      """
<html
>
<body>
Cheers
<div
class="header"></div
>
</head></html>
    """
    HtmlUtils.removeMarkup(src).trim.equals("Cheers")
  }

  it should "strip Javascript source" in {
    val src =
      """
<html>
<head>
<script type="text/javascript">
  console.log("Yo");
</script>
</head></html>
    """
    HtmlUtils.removeMarkup(src) should not include "console.log"
  }

}
