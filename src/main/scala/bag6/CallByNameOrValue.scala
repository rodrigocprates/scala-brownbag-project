package com.brownbag
package bag6

import scala.util.Random

object CallByNameOrValue extends App {

  // # call by name x by value
  def byValue(x: Long) = {
    println(s" First println: $x")
    println(s" Second println: $x")
  }

  def byName(x: => Long) = {
    println(s" First println: $x")
    println(s" Second println: $x")
  }

  // TODO - ask what happens
  //byValue(System.nanoTime()) // evaluates first the expression/parameter
  //byName(System.nanoTime()) // evaluates only when it's called (lazy) - useful to evaluate/validate/chekck/execute only inside the function (Try(somefunction) or Future(somefunction)

  // TODO what happens?
  byValue(1+Random.nextInt()) // two equal (evaluated before) -> "byName(  <a number>   )"
  byName(1+Random.nextInt()) // two different (evaluated after) -> "byName(  1+<random number>   )"

  // TODO what happens?
  //byValue(5+5) // evaluated before 1x -> "byName(  10   )"
  //byName(5+5) // evaluates inside 2x -> "byName(  5+5   )"


}
