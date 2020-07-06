package cl.test

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by cl on 2020/7/2.
  */
object WordCount {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("").setMaster("local")
    print(conf)
    val sc: SparkContext = new SparkContext(conf)
    print(sc)
  }
}
