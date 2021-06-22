package com.brownbag
package bag2

class BaseService {

  def logger = (x: String) => println(s"Logging this msg: $x")

  def commonFunction(): String = "that's a common function from BaseService"

}
