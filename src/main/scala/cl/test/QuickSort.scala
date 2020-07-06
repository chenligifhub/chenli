package cl.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}



/**
  * Created by cl on 2020/6/30.
  */
object QuickSort {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("test")
    val sc: SparkContext = new SparkContext(conf)
    val list1: List[Int] = List(5,7,3,6,8)
    val list2: List[Int] = List(2,3,5,7)
    val list3 = list1 ++: list2
    val list4: List[Int] = list3.sorted
    val rdd: RDD[Int] = sc.makeRDD(list4.toArray)
    val map: RDD[(Int, Int)] = rdd.map((_,1))
    val count: Long = map.count()
    print(count)
    if (count % 2 == 0){
      val left = count / 2 - 1
      val reght = left + 1

    } else rdd.count()
    sc.stop()
  }

  /**
    * @param list 传入一个Int型集合或数组
    * @return 返回排序后的集合或数组
    */
  def quickSort(list: List[Int]):List[Int] = list match {
    case Nil => Nil
    case List() => List()
    case head :: tail =>
      val (left, right) = tail.partition( _ < head)
      quickSort(left) ::: head :: quickSort(right)
  }
}
