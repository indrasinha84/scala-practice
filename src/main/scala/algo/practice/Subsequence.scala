package algo.practice

import java.util
import java.util.ArrayList
import scala.annotation.tailrec


object Subsequence {

  def main(args: Array[String]): Unit = {
    val line = "MKHKGJJGGH;XMKGJGRJH"
    val Array(left, right) = line.split(';')
    System.out.println(findSequence(left, right, "").head)

  }

  private def findSequence(left: String, right: String, result: String): Seq[String] = left.flatMap(c => right.split(c.toString, 2) match
    case Array(_, remaining) => findSequence(left.tail, remaining, result + c)
    case _ => Seq(result)).sortBy(-_.length)
}
