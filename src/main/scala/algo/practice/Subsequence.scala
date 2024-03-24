package algo.practice


object Subsequence:

  def main(args: Array[String]): Unit =
    //    val line = "MKHKGJJGGH;XMKGJJGRJGH"
    val line = "oxcpqrsvwf;shmtulqrypy"
    val Array(left, right) = line.split(';')
    println(findSequence(left, right, "").maxBy(_.length))
    println(findSequenceWithDP(left, right))

private def findSequence(left: String, right: String, result: String): Seq[String] =
  if left.isEmpty then
    Seq(result)
  else
    left.flatMap(c => right.split(c.toString, 2) match
      case Array(_, remaining) => findSequence(left.split(c.toString, 2).last, remaining, result + c)
      case _ => Seq(result)
    )

private def findSequenceWithDP(left: String, right: String): String = {
  if left.toSet.intersect(right.toSet).isEmpty then
    ""
  else {
    var maxValue = 0
    var maxI = -1
    var maxJ = -1
    val dpCache = Array.fill(left.length + 1, right.length + 1)(0)
    (1 to left.length).foreach(i => (1 to right.length).foreach(j => {
      if left(i - 1) == right(j - 1) then dpCache(i)(j) = dpCache(i - 1)(j - 1) + 1
      else dpCache(i)(j) = dpCache(i)(j - 1).max(dpCache(i - 1)(j))
      if dpCache(i)(j) > maxValue then {
        maxValue = dpCache(i)(j)
        maxI = i
        maxJ = j
      }
    }))
    dpCache.map(_.max).max
    if maxI == -1 || maxJ == -1 then ""
    else buildString(left, dpCache, maxI, maxJ)
  }
}

private def buildString(left: String, dpCache: Array[Array[Int]], maxI: Int, maxJ: Int): String = {
  var result: String = ""
  var i: Int = maxI
  var j: Int = maxJ
  while i != 0 && j != 0 do
    if dpCache(i - 1)(j) == dpCache(i)(j) then
      i -= 1
    else if dpCache(i)(j - 1) == dpCache(i)(j) then
      j -= 1
    else
      i -= 1
      j -= 1
      result = left.charAt(i) + result
  result
}