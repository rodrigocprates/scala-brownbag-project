package com.brownbag
package bag5

import scala.util.Try

object Main extends App {

  def factorial(x: Integer): Integer = {
    println(s"Number is $x")
    if (x == 0) {
      println(s"x is ZERO, so.. returning 1")
      1
    } else {
      val i = x * factorial(x - 1)
      //println(s"x * factorial($x - 1) = $i")
      i
    }
  }

  // factorial
  println(factorial(2)) // 5 = 5*4*3*2*1

  // # call by name x by value
  def byValue(x: Long) = {
    println(x)
    println(x)
  }

  def byName(x: => Long) = {
    println(x)
    println(x)
  }

  //println(byValue(System.nanoTime())) // evaluates first the expression/parameter
  //println(byName(System.nanoTime())) // evaluates only when it's called (lazy) - useful to evaluate/validate/chekck/execute only inside the function (Try(somefunction) or Future(somefunction)

  val tryInt: Try[Int] = Try(1)
  //println(Try(throw new Exception)) // a parameter, evaluated only inside Try


  // # recursion
  def sum(num: Int): Int = {
    if (num == 1) 1
    else sum(-1)
  }

  def sum(num: Int, res: Int): Int = {
    if (num == 1) res
    else sum(num - 1, res + num)
  }

  // # functional with Either -
  def aSum(a: Int, b: Int): Int = { // never know that it can throw an exception
    if (a < 0 || b < 0)
      throw new Exception("An Error")

    a + b
  }

  def aSumWithExceptionMsg(a: Int, b: Int): Either[String, Int] = { // know what to expect
    if (a < 0 || b < 0)
      Left("An Error")
    else
      Right(a + b)
  }

  //println(aSum(1,-1)) // with (1,-1) we don't know that an exception can explode
  println(aSumWithExceptionMsg(1, 2).getOrElse(throw new Exception)) // works like Option (None or Some)


}
