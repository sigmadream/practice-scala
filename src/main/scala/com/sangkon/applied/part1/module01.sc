// Starting Scala
val a = 10
val b = 20

if (a > b) {
  println(a)
} else {
  println(b)
}

def findMax(a: Int, b: Int): Int = {
  if (a > b) a
  else b
}

val m = if (a > b) a else b
println(m)

def maxSquaredDoubled(a: Int, b: Int): Int = {
  if (a > b) {
    val squared = a * a
    squared * 2
  } else {
    val squared = b * b
    squared * 2
  }
}

maxSquaredDoubled(10, 20)

val divided = try {
  a / (b - 10)
}
catch {
  case ae: ArithmeticException => 0
}

var a = 0

while (a < 10) {
  println(s"While Loop! $a")
  a += 1
}

// Dropped Scala 3: Do-While
// https://docs.scala-lang.org/scala3/reference/dropped-features/index.html
//var x = 0
//do {
//  println("Do - While Loop!")
//  x += 1
//} while (x < 10)