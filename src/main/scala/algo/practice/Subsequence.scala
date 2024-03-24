package algo.practice

object Subsequence:

  def main(args: Array[String]): Unit =
    val line = "MKHKGJJGGH;XMKGJJGRJGH"
    val Array(left, right) = line.split(';')
    println(findSequence(left, right, "").maxBy(_.length))

  private def findSequence(left: String, right: String, result: String): Seq[String] =
    if left.isEmpty then
      Seq(result)
    else
      left.flatMap(c => right.split(c.toString, 2) match
        case Array(_, remaining) => findSequence(left.split(c.toString, 2).last, remaining, result + c)
        case _ => Seq(result)
      )
