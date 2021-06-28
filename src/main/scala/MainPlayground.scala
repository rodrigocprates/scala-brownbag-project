package com.brownbag

object MainPlayground extends App {


/*

  // # call by name x by value
  def byValue(x: Long) = {
    println(x)
    println(x)
  }

  def byName(x: => Long) = {
    println(x)
    println(x)
  }

  println(byValue(System.nanoTime())) // evaluates first the expression/parameter
  println(byName(System.nanoTime())) // evaluates only when it's called (lazy) - useful to evaluate/validate/chekck/execute only inside the function (Try(somefunction) or Future(somefunction)

  def loop: Int = loop

  def x: Int = 2
*/

  ///////


  def loop: Boolean = loop
  def x: Boolean = loop

  val y:Boolean = loop

  false && loop
  true && loop

/*
  def and(x:Boolean, y:Boolean): Boolean = if (x) y else false

  and(true, false)
  and(false, loop)

  def and(x: Boolean, y: => Boolean): Boolean if (x) y else false

  and(false, loop)
*/

}
