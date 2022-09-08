package com.sangkon.s99.workingwithlists

object workWithLists extends App {

  // P01 (*) Find the last element of a list.
  def last[T](ls: List[T]): T = ls.last

  def lastRecursive[T](ls: List[T]): T = ls match {
    case h :: Nil => h
    case _ :: tail => lastRecursive(tail)
    case _ => throw new NoSuchElementException
  }

  // P02 (*) Find the last but one element of a list.
  def penultimate[T](ls: List[T]): T =
    if (ls.isEmpty) throw new NoSuchElementException
    else ls.init.last

  def penultimateRecursive[T](ls: List[T]): T = ls match {
    case h :: _ :: Nil => h
    case _ :: tail => penultimateRecursive(tail)
    case _ => throw new NoSuchElementException
  }

  // P03 (*) Find the Kth element of a list.
  def nthBuiltin[A](n: Int, ls: List[A]): A =
    if (n >= 0) ls(n)
    else throw new NoSuchElementException

  def nthRecursive[A](n: Int, ls: List[A]): A = (n, ls) match {
    case (0, h :: _) => h
    case (n, _ :: tail) => nthRecursive(n - 1, tail)
    case (_, Nil) => throw new NoSuchElementException
  }

  // P04 (*) Find the number of elements of a list.
  def lengthBuiltin[A](ls: List[A]): Int = ls.length

  def lengthRecursive[A](ls: List[A]): Int = ls match {
    case Nil => 0
    case _ :: tail => 1 + lengthRecursive(tail)
  }

  def lengthTailRecursive[A](ls: List[A]): Int = {
    def lengthR(result: Int, curList: List[A]): Int = curList match {
      case Nil => result
      case _ :: tail => lengthR(result + 1, tail)
    }

    lengthR(0, ls)
  }

  def lengthFunctional[A](ls: List[A]): Int = ls.foldLeft(0) { (c, _) => c + 1 }

  // P05 (*) Reverse a list.
  def reverseBuiltin[A](ls: List[A]): List[A] = ls.reverse

  def reverseRecursive[A](ls: List[A]): List[A] = ls match {
    case Nil => Nil
    case h :: tail => reverseRecursive(tail) ::: List(h)
  }

  def reverseTailRecursive[A](ls: List[A]): List[A] = {
    def reverseR(result: List[A], curList: List[A]): List[A] = curList match {
      case Nil => result
      case h :: tail => reverseR(h :: result, tail)
    }

    reverseR(Nil, ls)
  }

  def reverseFunctional[A](ls: List[A]): List[A] = ls.foldLeft(List[A]()) { (r, h) => h :: r }
}

