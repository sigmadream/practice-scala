package com.sangkon.proginscala.ch15

abstract class Expr

case class Var(name: String) extends Expr

case class Number(num: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object MainApp extends App {
  @main
  def main() = {
    val v = Var("X")
    val op = BinOp("+", Number(1), v)
    println(v.name)
    println(op.left)
    println(op)
    println(op.right == Var("X"))
    val op2 = op.copy(operator = "-")
    println(op2)

    val sTop = simplifyTop(UnOp("-", UnOp("-", Var("X"))))
    println(sTop)
  }

  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e
    case BinOp("+", e, Number(0)) => e
    case BinOp("*", e, Number(1)) => e
    case _ => expr
  }
}
