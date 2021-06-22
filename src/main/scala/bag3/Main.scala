package com.brownbag
package bag3

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Main extends App {

  // Future
  val aFuture = Future({
    println("Processing Future..")
    Thread.sleep(1000)
    println("Computing some value..")
    50
  })

  aFuture.onComplete {
    case Success(value) => println(s"Just completed!")
    case Failure(exception) => exception.printStackTrace()
  }
  Thread.sleep(2000)


  // Parallel
  val simpleList = List("one", "two", "three", "four")
  val parList = simpleList.par // show javadoc
  simpleList.foreach(x => println(s"Item: $x. ${Thread.currentThread().getName}"))
  parList.foreach(x => println(s"Item: $x. ${Thread.currentThread().getName}"))

}
