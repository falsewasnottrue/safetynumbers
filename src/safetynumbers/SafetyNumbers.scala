package safetynumbers

object SafetyNumbers extends App {

//  val cs = 20 :: 10 :: Nil
//  val cs = 10 :: 0 :: Nil
//  val cs = 25 :: 25 :: 25 :: 25 :: Nil
  val cs = 24 :: 30 :: 21 :: Nil

  println(safetyNumbers(10 :: 0 :: 0 :: Nil))
  import scala.io._
  val lines = Source.fromFile("src/safetynumbers/A-small-practice.in").getLines
  lines.next // drop #cases

  var c = 1
  while (lines.hasNext) {
    val args = lines.next.split(" ").toList.map(_.toInt)
    val res = safetyNumbers(args.drop(1))

    val printable = res map (d => d * 100) map (d => f"$d%2.6f") mkString " "
    println(s"Case #$c: $printable")
    c = c + 1
  }

  def safetyNumbers(cs: List[Int]): List[Double] = {
    val sum = cs.sum
    val target: Double = (2 * sum) / cs.length

    cs map (c => (target - c) / sum)
  }
}
