package com.brownbag
package bag2

import org.sparkproject.jetty.io.ByteBufferPool.Bucket

import java.io.File

object Main {

  def main(args: Array[String]): Unit = {
    // create 2 functions
    println(loadQueries())
    executeQueries(loadQueries())

    // export to a class + functions to delegate
    try {
      // show debug
      QueryService.executeLoadedQueries()
    } catch {
      case e: Exception => println(s"Exception thrown!!! Exception: $e")
    } finally {
      println("It will always execute in a try-catch block")
    }

    // QueryService extending BaseService
    println(QueryService.commonFunction())


    // some class definitions
    class S3FileProcessor(user: String, pass: String) {

      def loadFiles(bucket: String): List[Object] = {
        authenticate(user, pass)
        println("Returning files..: ")
        List("c360_file.avro", "pas_file.xls")
      }

      private def authenticate(user: String, pass: String): Boolean = {
        println("Authenticating...")
        // do some authentication logic
        true
      }
    }

    val processor = new S3FileProcessor("user", "password")
    val files = processor.loadFiles("/bucket/my_files")
    println(files)



  }

  def loadQueries(): List[String] = {
    List("select * from table1", "select * from table2")
  }

  def executeQueries(queries: List[String]): List[Boolean] = {
    queries.map(query => {
      println(s"Executing query $query...")
      true
    })
  }

}
