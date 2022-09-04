package learning

object CurryingExample {
  def main(args: Array[String]): Unit = {
    println(s"Results of sumCube is ${sumCube(2, 5)}")
    val sumFunction = sum(x => x * x * x)
    println(s"Results of sum cube is ${sumFunction(2, 5)}")
    println(s"Results of sum cube is ${sumCurrying(x => x * x * x)(2, 5)}")
    println(s"Results of sum cube is ${sum(x => x * x * x)(2, 5)}")

  }

  def id(x: Int): Int = x

  def cube(x: Int): Int = x * x * x

  def fact(x: Int): Int = if (x == 1) 1 else x * fact(x - 1)

  def sumInts(a: Int, b: Int): Int =
    if a > b then 0 else a + sumInts(a + 1, b)

  def sumCube(a: Int, b: Int): Int =
    if a > b then 0 else cube(a) + sumCube(a + 1, b)

  def sumFactorial(a: Int, b: Int): Int =
    if a > b then 0 else fact(a) + sumFactorial(a + 1, b)

  def sumCurrying(f: Int => Int): (Int, Int) => Int =
    def sumF(a: Int, b:Int): Int =
      if a > b then 0 else f(a) + sumF(a + 1, b)
    sumF

  def sum(f: Int => Int)(a: Int, b: Int): Int =
      if a > b then 0 else f(a) + sum(f)(a + 1, b)

}
