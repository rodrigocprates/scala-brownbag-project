package com.brownbag
package bag1

import scala.collection.mutable.ListBuffer

object Main {

  def main(args: Array[String]): Unit = {
    // print
    println("hello world")

    // val and var
    val myVal: String = "yellow"
    var myVar = 2 // infer to Integer type
    //myVal = 2 -- immutable, no side effects
    myVar = 30
    println(s"myVal=$myVal, myVar=$myVar") // string interpolation

    // if conditions
    val condition = if (myVal == "blue") "it's yellow" else "it's NOT yellow"
    println(condition)

    // code blocks
    val something = {
      val a = 5
      val b = 10
      a + b
    }
    println(something)

    // match case
    val whatsTheColor = myVal match {
      case "yellow" => "that's yellow"
      case "blue" => "that's blue"
      case _ => "that's another color"
    }
    println(whatsTheColor)

    // for
    val myList = List(1, 2, 3, 4, 5)
    for (number <- myList) println(s"Number: $number")
    myList.foreach(number => println(s"Number again: $number"))

    val myMap = Map("a" -> 123, "b" -> 456)
    for ((key, value) <- myMap) println(s"Map: key=$key, value=$value")

    // Class
    class Person( name: String, age: Int) {
      override def toString: String = s"Override toString method: Name=$name, Age=$age"
    }
    println(new Person("Rodrigo", 30))

    // Built-in functions from collections

    // immutable list
    val transformingList = List(1, 2, 3).map(n => s"Number $n")
    println(transformingList)

    // mutable list
    val mutableList = ListBuffer(50, 60, 70)
    mutableList+=80
    println(mutableList)

    val filteredList = (1 to 50).toList.filter(_ > 40)
    println(filteredList)

  }




}
