package com.sangkon.learningscala.ch09

import scala.util.{Random, Try}

trait SafeStringUtils {
  def trimToNone(s: String): Option[String] = {
    Option(s) map (_.trim) filterNot (_.isEmpty)
  }

  def parseToInt(s: String): Option[Int] = {
    trimToNone(s) flatMap { x => Try(x.toInt).toOption }
  }

  def randomLetters(size: Int): String = {
    val validChars: Seq[Char] = ('A' to 'Z') ++ ('a' to 'z')
    1 to size map { _ => Random nextInt validChars.size } map validChars mkString ""
  }
}

object SafeStringUtils extends SafeStringUtils


