import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by srinidhi on 13/6/17.
  */

object SparkTest {
  def main(args: Array[String]): Unit = {

    val appName = "SparkTest"
    val master = "local"

    val conf = new SparkConf().setAppName(appName).setMaster(master)
    val sc = new SparkContext(conf)
//
    val lines = sc.textFile("/home/srinidhi/code/scala/SparkTest/src/main/resources/README.md")
    val lineCount = lines.count()
    val wordCount = lines.map(_.split(" ").size).reduce(_ + _)

    println("Number of lines " + lineCount + "\n Number of words " + wordCount)

    println(appName + ", " + master)

  }
}
