package com.sangkon.s99.workingwithlists

import com.sangkon.s99.workingwithlists.workWithLists
import org.scalatest.*
import org.scalatest.flatspec.*
import org.scalatest.matchers.*


class TestWorkWithLists extends AnyFlatSpec with should.Matchers {

  "A Last Use Built-in" should "Find the last element of a list." in {
    val input = List(1, 2, 3, 4, 5)
    workWithLists.last(input) should be(input.last)
  }

  "A Last Use Recursive" should "Find the last element of a list." in {
    val input = List(1, 2, 3, 4, 5)
    workWithLists.lastRecursive(input) should be(input.last)
  }

  "A Penultimate" should "Find the penultimate of a list." in {
    val input = List(1, 2, 3, 4, 5)
    workWithLists.penultimate(input) should be(input.init.last)
  }

  "A Penultimate Recursive" should "Find the penultimate of a list." in {
    val input = List(1, 2, 3, 4, 5)
    workWithLists.penultimateRecursive(input) should be(input.init.last)
  }

  "A nth" should "Find the Kth element of a list." in {
    workWithLists.nthBuiltin(2, List(1, 1, 2, 3, 5, 8)) should be(2)
  }

  "A nth Recursive" should "Find the Kth element of a list." in {
    workWithLists.nthRecursive(2, List(1, 1, 2, 3, 5, 8)) should be(2)
  }

  "Length" should "Find the number of elements of a list." in {
    workWithLists.lengthBuiltin(List(1, 1, 2, 3, 5, 8)) should be(6)
  }

  "Length Recursive" should "Find the number of elements of a list." in {
    workWithLists.lengthRecursive(List(1, 1, 2, 3, 5, 8)) should be(6)
  }

  "Length Tail Recursive" should "Find the number of elements of a list." in {
    workWithLists.lengthTailRecursive(List(1, 1, 2, 3, 5, 8)) should be(6)
  }

  "Length More FP" should "Find the number of elements of a list." in {
    workWithLists.lengthFunctional(List(1, 1, 2, 3, 5, 8)) should be(6)
  }

  "Reverse" should "Find the number of elements of a list." in {
    workWithLists.reverseBuiltin(List(1, 1, 2, 3, 5, 8)) should be(List(8, 5, 3, 2, 1, 1))
  }

  "Reverse Recursive" should "Find the number of elements of a list." in {
    workWithLists.reverseRecursive(List(1, 1, 2, 3, 5, 8)) should be(List(8, 5, 3, 2, 1, 1))
  }

  "Reverse Tail Recursive" should "Find the number of elements of a list." in {
    workWithLists.reverseTailRecursive(List(1, 1, 2, 3, 5, 8)) should be(List(8, 5, 3, 2, 1, 1))
  }

  "Reverse More FP" should "Find the number of elements of a list." in {
    workWithLists.reverseFunctional(List(1, 1, 2, 3, 5, 8)) should be(List(8, 5, 3, 2, 1, 1))
  }
}
