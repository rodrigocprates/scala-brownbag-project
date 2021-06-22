package com.brownbag
package bag2

object QueryService extends BaseService {

  // let this one public
  def executeLoadedQueries(): List[Boolean] = {
    println("Executing queries..")
    val executionStatus = executeQueries(loadQueries())
    println("Queries executed")

    executionStatus
  }

  //override def commonFunction(): String = "specific to QueryService"

  // encapsulate
  private def loadQueries(): List[String] = {
    logger("loading queries..")
    List("select * from table1", "select * from table2")
  }

  private def executeQueries(queries: List[String]): List[Boolean] = {
    queries.map(query => {
      println(s"Executing query $query...")
      throw new Exception("Something wrong happened..")
      true
    })
  }

}
