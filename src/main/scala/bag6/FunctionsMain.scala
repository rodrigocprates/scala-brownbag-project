package com.brownbag
package bag6

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object FunctionsMain extends App {

  def loadQueriesUgly(someFilter: String): List[String] = {
    val myQueries = List("select * from table1", "select * from table2") // loaded queries

    if (someFilter == null || someFilter == "")
      myQueries
    else {
      var myFilteredList = new ListBuffer[String]
      for (query <- myQueries) {
        if (query.contains(someFilter)) {
          myFilteredList += query
        }
      }
      myFilteredList.toList
    }
  }

  def loadQueriesFunctional(optionalFilter: Option[String]): List[String] = {
    val myQueries = List("select * from table1", "select * from table2") // loaded queries
    optionalFilter
      .map(myFilter => myQueries.filter(query => query.contains(myFilter)))
      .getOrElse(myQueries)

  }

  // TODO - UGLY and verbose queries
  //println(loadQueriesUgly("table2"))
  //println(loadQueriesUgly("notfound"))
  //println(loadQueriesUgly(""))
  //println(loadQueriesUgly(null))

  // TODO - functional
  //println(loadQueriesFunctional(Option("table2")))
  //println(loadQueriesFunctional(Option("notfound")))
  //println(loadQueriesFunctional(Option.empty))


  // TODO - next: executed QUERIES ugly and with Either

  def executeQueries(queries: List[String]): Boolean = { // doesn't need a Option[List[String]]
      queries.foreach(query => println(s"Executing query [$query]..."))
      true
  }
  executeQueries(loadQueriesFunctional(Option("table2"))) // what if an Exception happens? don't know from the signature. Functional way?
  // TODO do a try catch

  // TODO - refactoring with Either

  def executeQueriesWithEither(queries: List[String]): Either[Exception, Boolean] = { // doesn't need a Option[List[String]]
    try {
      queries.foreach(query => println(s"Executing query [$query]..."))
      //throw new Exception("DATABASE CONNECTION FAILED")
      Right(true)
    } catch {
      case exception: Exception => Left(exception)
    }
  }

  //val executedQueriesWithEither: Either[Exception, Boolean] = executeQueriesWithEither(loadQueriesFunctional(Option("table2")))
  //val executionStatus = if(executedQueriesWithEither.isLeft) executedQueriesWithEither.left.get.getMessage else "OK"
  //println(executionStatus)


}
