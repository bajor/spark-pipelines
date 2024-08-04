package io

import org.apache.spark.sql.{DataFrame, SparkSession}
import config.FileTargetConfig

class FileWriter(spark: SparkSession) {
  def write(df: DataFrame, config: FileTargetConfig): Unit = {
    df.write.format(config.format).save(config.path)
  }
}
