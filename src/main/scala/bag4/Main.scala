package com.brownbag
package bag4

import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object Main extends App {

  // Setup spark config
  val spark = SparkSession.builder()
    .config("spark.master", "local")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  import spark.implicits._

  val dfWithSchema = Seq(
    (1, "Rodrigo"),
    (2, "Jim")
  ).toDF("id", "name")
  dfWithSchema.printSchema()
  dfWithSchema.show()

  val df: DataFrame = spark.createDataFrame(Seq(
    (1, "Rodrigo"),
    (2, "Jim")
  ))

  val df2: DataFrame = spark.createDataFrame(Seq(
    (1, "Rodrigo"),
  ))

  val diffDF: Dataset[Row] = df.except(df2)
  diffDF.show()

  val missingIDs = diffDF.select("_1").map(_.getInt(0)).collect().toList // missing ID = 2
  println(missingIDs)

  // Next

  // Load data from a table
  // infer schema VS define schema
  // get difference
}
