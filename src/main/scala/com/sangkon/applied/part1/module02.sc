val x = 10

var y = x * 2

y = 11

for (i <- 1 to 10) yield i * 2

def max(x: Int, y: Int): Int =
  if (x > y) x else y

def min(x: Int, y: Int): Int =
  if (x < y) x else y

println(max(5, 6))

// Unit
def sayHi(name: String): Unit =
  println(s"hello $name")

sayHi("Scala class")

def procedureSyntax(name: String) = {
  println(s"hello $name")
}

procedureSyntax("Scala")

// Expressions and Statements

val a = 10
val b = 20

if (a > b) a else b
if (a > b) println(s"max is $a") else println(s"max is $b")

var doIt: Boolean = true

val result = while (doIt) {
  println("Hello")
  doIt = false
}

var x = 5
val y = x = 10

println(x)
println(y)

val div = 0

val n = try {
  x / div
} catch {
  case ex: ArithmeticException => 0
}

def add(a: Int, b: Int) = {
  val result = a + b
}

add(5, 6)

// Tuple
def sumAndDifference(a: Int, b: Int): (Int, Int) = {
  val sum = a + b
  val difference = a - b
  (sum, difference)
}

val res = sumAndDifference(10, 5)

res._1
res._2

val (sm, df) = sumAndDifference(10, 5)

val (a, b, c, d, e) = (0, 'u', 8, 1, "too")

// Rewriting
val x = 1 + 2

val y = 1.+(2)

val s = "hello"

s.charAt(1)
s charAt 1

// println "hello" // will not compile

System.out println "hello"

// --- apply and update

val arr = Array("scooby", "dooby", "doo")

arr.apply(1)

arr(0)

arr.update(0, "scrappy")

arr(1) = "dappy"

print(arr.mkString(","))

val arr2 = Array.apply(1, 2, 3)

val z = 10
// z(2) // does not compile

val xs = List(1, 2, 3)
xs(1) // works
// xs(1) = 10 // does not compile


val array1: Array[Int] = Array(1, 2, 3)
val list1: List[String] = List("scooby", "dooby", "doo")

val array2 = Array(1, 2, 3)
val list2 = List("scooby", "dooby", "doo")

def squareRootsOf(xs: List[Int]): List[Double] = {
  for (x <- xs) yield math.sqrt(x)
}

squareRootsOf(List(1, 2, 3, 4, 5, 6))

// type parameters are not optional, this will not compile:
// def badSquareRootsOf(xs: List): List = {
//   for (x <- xs) yield math.sqrt(x)
// }

// List initializers
val lista = List(1, 2, 3)
val listb = 4 :: 5 :: 6 :: Nil
val listc = lista ::: listb

// common beginner mistake:
// val listd = lista :: listb

val v = Vector(1, 2, 3, 4)

def squareRootOfAll(xs: Seq[Int]): Seq[Double] =
  xs.map(x => math.sqrt(x))

squareRootOfAll(v)
squareRootOfAll(listc)
squareRootOfAll(array2)


val set1 = Set(1, 2, 3, 1, 2, 4, 5)
// squareRootOfAll(set1) // does not compile

// Arrays are Mutable:
val arr = Array("scooby", "dooby", "doo")
arr(0) = "scrappy"
arr(1) = "dappy"

arr.mkString(" ")
// Lists and Vectors are not mutable

val xs1 = List(1, 2, 3)
val xs2 = 0 :: xs1
var xs3 = List(4, 5, 6)
xs3 = xs2 ::: xs3 // because it's a var

// Sets may be either:

import scala.collection._

val s1 = mutable.Set(1, 2, 3)
var s2 = immutable.Set(1, 2, 3)

// += on both types:
s1 += 4 // calls += on mutable.Set
s1

s2 += 4 // turns into s2 = s2 + 4
s2

// Maps also may be either
val m1 = mutable.Map('a' -> 1, 'b' -> 2, 'c' -> 3)
var m2 = immutable.Map('d' -> 4, 'e' -> 5, 'f' -> 6)

m1 ++= m2
m2 += 'g' -> 7
m2

1 -> "one"

2.->("two")

ArrowAssoc(3).->("three")


// easy map iteration

val mapToRiches = Map(
  1 -> "steal underpants",
  2 -> "???",
  3 -> "profit"
)

for ((step, instruction) <- mapToRiches) {
  println(s"Step $step - $instruction")
}
