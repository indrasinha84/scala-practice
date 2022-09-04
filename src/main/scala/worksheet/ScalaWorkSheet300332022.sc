//def fac(n : Int) =
//  var r = 1
//  for (i <- 1 to n) r = r * i
//
//
//fac(25)
//
//import scala.math.*
//
//sqrt(5)
//
//  import scala.math.*
//  var range = 1 to 10
//  range.map(sqrt(_)).toArray
//
//
//  "Rhine".permutations// Returns iterator


/*import scala.collection.mutable.ArrayBuffer
//
//  val intBuffer = new ArrayBuffer[Int]
//  intBuffer += 10
//  intBuffer += 20
//
val stringBuffer = ArrayBuffer("Hello", "World")
//  stringBuffer += "Indranil"
//  stringBuffer.foreach(println)
//
//  val anyArray = new Array[Any](10)
//  anyArray(0) = "Hello"
//  anyArray(1) = 4
//
//  for (i <- anyArray) println(i)
//
//  val bool = anyArray(0).isInstanceOf
stringBuffer(0)*/







def example = 2      // evaluated when called
val example = 2      // evaluated immediately
lazy val example = 2 // evaluated once when needed

def square(x: Double)    // call by value
def square(x: => Double) // call by name
//def myFct(bindings: Int*) =  ...  // bindings is a sequence of int, containing a varying # of arguments


// sum takes a function that takes an integer and returns an integer then
// returns a function that takes two integers and returns an integer
//def sum(f: Int => Int): (Int, Int) => Int =
//  def sumf(a: Int, b: Int): Int = f(a) + f(b)
//  sumf

// same as above. Its type is (Int => Int) => (Int, Int) => Int
//def sum(f: Int => Int)(a: Int, b: Int): Int =  ...

// Called like this
//sum((x: Int) => x * x * x)          // Anonymous function, i.e. does not have a name
//sum(x => x * x * x)                 // Same anonymous function with type inferred
//
//def cube(x: Int) = x * x * x
//sum(x => x * x * x)(1, 10) // sum of 1 cubed and 10 cubed
//sum(cube)(1, 10)           // same as above


