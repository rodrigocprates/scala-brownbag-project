package com.brownbag
package bag6

object FactorialMain extends App {

  def factorialWithSideEffects(n: Int): Integer = {
    var f = 1
    for(i <- 1 to n) {
      f = f * i
    }
      // 1*1*2*3*4*5
    f
  }

  def factorialFunctional(x: Integer): Integer = {
    if (x == 0)
      1
    else
      x * factorialFunctional(x - 1)

    /*
    f=5
      5 * 4! (factorial 4=24) = 5*24 = 120
      4 * 3! (factorial 3=6) = 4*6 = 24
      3 * 2! (factorial 2=2) = 3*2 = 6
      2 * 1! (factorial 1=1) = 2*1 = 2
     */
  }

  //println(factorialWithSideEffects(5))
  println(factorialFunctional(5))



}
