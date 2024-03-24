package algo.practice

import scala.annotation.tailrec

object Subsequence:

  def main(args: Array[String]): Unit =
    val line = "MKHKGJJGGH;XMKGJJGRJGH"
    val Array(left, right) = line.split(';')
    println(findSequence(left, right, "").maxBy(_.length))
    println(findSequenceWithTailRec(left, right, ""))

  private def findSequence(left: String, right: String, result: String): Seq[String] =
    if left.isEmpty then
      Seq(result)
    else
      left.flatMap(c => right.split(c.toString, 2) match
        case Array(_, remaining) => findSequence(left.split(c.toString, 2).last, remaining, result + c)
        case _ => Seq(result)
      )

  @tailrec
  private def findSequenceWithTailRec(left: String, right: String, result: String): String =
    if left.isEmpty || right.isEmpty then
      result
    else
      val positionInRight = right.lastIndexOf(left.last)
      if positionInRight == -1 then
        findSequenceWithTailRec(left.init, right, result)
      else
        findSequenceWithTailRec(left.init, right.take(positionInRight), left.last + result)
