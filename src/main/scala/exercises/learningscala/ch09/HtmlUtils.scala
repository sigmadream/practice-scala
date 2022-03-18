package exercises.learningscala.ch09

object HtmlUtils {
  def removeMarkup(input: String) = {
    input
      .replaceAll("(?s)<script.*</script>", "")
      .replaceAll("""</?\w[^>]*>""","")
      .replaceAll("<.*>","")
  }
}
