import collection.JavaConversions._

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.rdd.PairRDDFunctions

object Dante {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Dante")
    val sc = new SparkContext(conf)
    val text = sc.textFile("dante.txt", 1).cache()

    val wordMap:PairRDDFunctions[String, Int] = text.flatMap(line => line.split("\\W")).map( word => (word, 1) )
    val counts = wordMap.reduceByKey(_ + _)
    val total = counts.count()
    counts.collect().foreach(println)
    println(s"Words: $total")
    Thread.sleep(5000000)
    sc.stop()
  }
}