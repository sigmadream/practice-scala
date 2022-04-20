package com.sangkon.s99

import org.scalatest._
import flatspec._
import matchers._


class p01Test extends AnyFlatSpec with should.Matchers {

  "A Last Use Built-in" should "Find the last element of a list." in {
    val input = List(1, 2, 3, 4, 5)
    p01.last(input) should be(input.last)
  }

  "A Last Use Recursive" should "Find the last element of a list." in {
    val input = List(1, 2, 3, 4, 5)
    p01.lastRecursive(input) should be(input.last)
  }

  "A Penultimate" should "Find the penultimate of a list." in {
    val input = List(1, 2, 3, 4, 5)
    p01.penultimate(input) should be(input.init.last)
  }

  "A Penultimate Recursive" should "Find the penultimate of a list." in {
    val input = List(1, 2, 3, 4, 5)
    p01.penultimateRecursive(input) should be(input.init.last)
  }
}
