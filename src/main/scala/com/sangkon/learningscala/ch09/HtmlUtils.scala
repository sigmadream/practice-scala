package com.sangkon.learningscala.ch09

object HtmlUtils {
  def removeMarkup(input: String) = {
    input
      .replaceAll("(?s)<script.*</script>", "")
      .replaceAll("""</?\w[^>]*>""","")
      .replaceAll("<.*>","")
  }
}
