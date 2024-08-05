package spark

import org.apache.spark.sql.SparkSession

trait SparkConfig {
  def getSparkSession: SparkSession
}

class LocalSparkConfig(appName: String) extends SparkConfig {
  override def getSparkSession: SparkSession = {
    SparkSession
      .builder()
      .appName(appName)
      .master("local[*]")
      .getOrCreate()
  }
}

class ClusterSparkConfig(appName: String, masterUrl: String)
    extends SparkConfig {
  override def getSparkSession: SparkSession = {
    SparkSession
      .builder()
      .appName(appName)
      .master(masterUrl) // Specify the cluster master URL
      .config(
        "spark.some.config.option",
        "some-value"
      ) // Add other cluster-specific configs
      .getOrCreate()
  }
}
