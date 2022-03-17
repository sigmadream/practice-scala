package exercises.learningscala.ch09

object HtmlUtils {
  def removeMarkup(input: String): String = {
    input
      .replaceAll("""</?\w[^>]*>""", "")
      .replaceAll("<.*>", "")
  }
}
