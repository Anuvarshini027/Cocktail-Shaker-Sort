import scala.util.control._

object Cocktail {

  def main(args: Array[String]) {
    val t1 = System.nanoTime
    var a: Array[Int] = Array(1000,100000,2334221);
    Cocktail.cocktailSort(a);
    println("Sorted array");
    Cocktail.printArray(a);
    val duration = (System.nanoTime - t1) / 1e9d
    println("Time in milli seconds:" + duration)
  }

  def cocktailSort(a: Array[Int]): Unit = {

    var swapped: Boolean = true;
    var start: Int = 0;
    var end: Int = a.length;
    var i: Int = 0;

    while (swapped == true) {
      // reset the swapped flag on entering the loop,
      //because it might be true from a
      // previous iteration.
      swapped = false
      val loop = new Breaks;
      //loop from left to right same as the bubble sort
      for (i <- 0 to end - 2 by 1) {
        if (a(i) > a(i + 1)) {
          var temp: Int = a(i);
          a(i) = a(i + 1);
          a(i + 1) = temp;
          swapped = true;
        }
      }
      // if nothing moved, then array is sorted.
      loop.breakable {
        if (swapped == false) { loop.break; }
      }
      //otherwise, reset the swapped flag so that it
      //can be used in the next stage
      swapped = false;

      //move the end point back by one, because
      // item at the end is in its rightful spot
      end = end - 1;

      //from right to left, doing the same
      // comparison as in the previous stage
      for (i <- end - 2 to start by -1) {
        if (a(i) > a(i + 1)) {
          var temp = a(i);
          a(i) = a(i + 1);
          a(i + 1) = temp;
          swapped = true;

        }
      }
      //increase the starting point, because
      //the last stage would have moved the next
      //smallest number to its rightful spot.
      start = start + 1;

    }
  }
  def printArray(a: Array[Int]): Unit = {
    var n = a.length;
    var i: Int = 0;
    for (i <- 0 to n - 1 by 1) {
      print(a(i) + " ");
    }
    println();
  }

}
