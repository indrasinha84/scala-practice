package learning

object HigherOrderFunctionsExample {
  def main(args: Array[String]): Unit = {
    println(s"Results of sumInts is ${sumInts(2, 5)}")
    println(s"Results of sum  ints is ${sum(id, 2, 5)}")

    println(s"Results of sumFactorial is ${sumFactorial(2, 5)}")
    println(s"Results of sum factorial is ${sum(fact, 2, 5)}")

    println(s"Results of sumCube is ${sumCube(2, 5)}")
    println(s"Results of sum cube is ${sum(cube, 2, 5)}")
    println(s"Results of sum cube is ${sum(x => x * x * x, 2, 5)}")

  }

  def id(x: Int): Int = x

  def cube(x: Int): Int = x * x * x

  def fact(x: Int): Int = if x == 1 then 1 else x * fact(x - 1)

  def sumInts(a: Int, b: Int): Int =
    if a > b then 0 else a + sumInts(a + 1, b)

  def sumCube(a: Int, b: Int): Int =
    if a > b then 0 else cube(a) + sumCube(a + 1, b)

  def sumFactorial(a: Int, b: Int): Int =
    if a > b then 0 else fact(a) + sumFactorial(a + 1, b)

  def sumLR(f: Int => Int, a: Int, b: Int): Int =
    if a > b then 0 else f(a) + sum(f, a + 1, b)

  def sum(f: Int => Int, a: Int, b: Int): Int =
    def loop(a: Int, acc: Int): Int =
      if a > b then acc else loop(a + 1, acc + f(a))
    loop(a, 0)

}
