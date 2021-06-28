package com.brownbag
package bag6

object GeneralMain extends App {

  // TODO - create a class with functions

  // some class definitions
  class S3FileProcessor(user: String, pass: String) {
    //def user = user
    def loadFiles(bucket: String): List[Object] = {
      authenticate(user, pass)
      println("Returning files..: ")
      List("c360_file.avro", "pas_file.xls")
    }

    private def authenticate(user: String, pass: String): Boolean = {
      println("Authenticating...")
      throw new Exception("User/pass wrong")
      // do some authentication logic
      true
    }
  }

  val processor = new S3FileProcessor("user", "password")
  //val files = processor.loadFiles("/bucket/my_files")
  try {
    val files = processor.loadFiles("/bucket/my_files")
    println(files)
  } catch {
    case e => println("Error: " + e)
  }
  // TODO throw Exception from Authenticate -> add a try-catch



  // TODO create another class that formats to a PDFFile type

  class FileFormatter() {
    def formatFilesToPDF(files: List[Object]): List[PDFFile] = {
      // some logic
      List()
    }
  }
  case class PDFFile(name: String, content: Array[Byte]) // good to define a model

  //val filesAsPDF = new FileFormatter().formatFilesToPDF(files)

  //println(filesAsPDF)

}
