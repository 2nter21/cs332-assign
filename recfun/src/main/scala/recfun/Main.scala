package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c < 0 || r < 0 || c > r)
      throw new IllegalArgumentException("input Index is Invalid")
    if (c == 0 || r == 0) 1
    else if (c == r) 1
    else pascal(c-1, r-1) + pascal(c, r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balance_in(chars: List[Char], openCnt: Int): Boolean = 
    {
      if(openCnt < 0) false
      else if(chars.isEmpty && openCnt == 0) true
      else if(chars.isEmpty && openCnt != 0) false
      else if(chars.head == '(') balance_in(chars.tail, openCnt + 1)
      else if(chars.head == ')') balance_in(chars.tail, openCnt - 1)
      else balance_in(chars.tail, openCnt)
    }
    balance_in(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0 || coins.isEmpty) 0
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
}
