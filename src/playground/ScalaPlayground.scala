package playground

object ScalaPlayground extends App {
  for (i <- 1 to 100) { var s = ""; if (i%3==0) s="type"; if (i%5==0) s+="safe"; if(s.isEmpty) s += i; println(s) }
}
