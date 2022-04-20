package com.sangkon.s99

object p01 extends App {
  def last[T](ls: List[T]): T = ls.last

  def lastRecursive[T](ls: List[T]): T = ls match {
    case h :: Nil => h
    case _ :: tail => lastRecursive(tail)
    case _ => throw new NoSuchElementException
  }

  def penultimate[T](ls: List[T]): T =
    if (ls.isEmpty) throw new NoSuchElementException
    else ls.init.last

  def penultimateRecursive[T](ls: List[T]): T = ls match {
    case h :: _ :: Nil => h
    case _ :: tail => penultimateRecursive(tail)
    case _ => throw new NoSuchElementException
  }
}
