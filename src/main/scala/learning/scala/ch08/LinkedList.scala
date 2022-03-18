package learning.scala.ch08

import scala.annotation.tailrec

class ListyHelper {
  def create[A](items: A*) = {
    var result: Listy[A] = new EmptyList[A]
    for (item <- items.reverse) {
      result = new NonEmptyList[A](item, result)
    }
    result
  }
}

abstract class Listy[A] {
  def foreach(f: A => Unit): Unit

  def apply(index: Int): Option[A]

  def headOption: Option[A] = apply(0)

  lazy val head: A = headOption.get

  def tail: Listy[A]

  def ::(a: A): Listy[A] = new NonEmptyList[A](a, this)

  def filter(f: A => Boolean): Listy[A] = {

    @tailrec
    def filterLists(src: Listy[A], dest: Listy[A], f: A => Boolean): Listy[A] = {
      src.headOption match {
        case Some(i) if f(i) => filterLists(src.tail, i :: dest, f)
        case Some(i) => filterLists(src.tail, dest, f)
        case None => dest
      }
    }

    val result: Listy[A] = filterLists(this, new EmptyList[A], f)
    result.reverse
  }


  lazy val size: Int = {

    @tailrec
    def count(src: Listy[A], total: Int): Int = {
      src.headOption match {
        case Some(i) => count(src.tail, total + 1)
        case None => total
      }
    }

    count(this, 0)
  }

  def map[B](f: A => B): Listy[B] = {

    @tailrec
    def mapLists[B](src: Listy[A], dest: Listy[B], f: A => B): Listy[B] = {
      src.headOption match {
        case Some(i) => mapLists(src.tail, f(i) :: dest, f)
        case None => dest
      }
    }

    val result: Listy[B] = mapLists(this, new EmptyList[B], f)
    result.reverse
  }

  lazy val reverse: Listy[A] = {

    @tailrec
    def reverseLists(src: Listy[A], dest: Listy[A]): Listy[A] = {
      src.headOption match {
        case Some(i) => reverseLists(src.tail, i :: dest)
        case None => dest
      }
    }

    reverseLists(this, new EmptyList[A])
  }
}

class NonEmptyList[A](val item: A, val tail: Listy[A]) extends Listy[A] {

  override def foreach(f: A => Unit): Unit = {
    f(item)
    tail.foreach(f)
  }

  override def apply(index: Int): Option[A] = {
    if (index < 1) Some(item) else tail.apply(index - 1)
  }
}

class EmptyList[A] extends Listy[A] {
  override def foreach(f: A => Unit): Unit = {}

  override def apply(index: Int): Option[A] = None

  override def tail: Listy[A] = null
}
