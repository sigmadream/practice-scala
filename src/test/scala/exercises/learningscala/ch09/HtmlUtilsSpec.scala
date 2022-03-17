package exercises.learningscala.ch09

import org.scalatest.flatspec.AnyFlatSpec


class HtmlUtilsSpec extends AnyFlatSpec {

  "The Html Utils object" should "remove single elements" in {
    HtmlUtils.removeMarkup("<br/>").equals("")
  }

  it should "remove paired elements" in {
    HtmlUtils.removeMarkup("<b>Hi</b>").equals("Hi")
  }

  it should "have no effect on empty strings" in {
    val empty = true
    HtmlUtils.removeMarkup("").isEmpty.equals(empty)
  }

}
