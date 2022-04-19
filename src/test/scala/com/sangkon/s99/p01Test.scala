package com.sangkon.s99

import org.scalatest._
import flatspec._
import matchers._


class p01Test extends AnyFlatSpec with should.Matchers {
  "A Last" should "Find the last element of a list." in {
    val input = List(1, 2, 3, 4, 5)
    p01.last(input) should be(input.last)
  }
}
