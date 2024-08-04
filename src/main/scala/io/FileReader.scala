package io

import org.apache.spark.sql.{DataFrame, SparkSession}
import config.FileSourceConfig

class FileReader(spark: SparkSession) {
  def read(config: FileSourceConfig): DataFrame = {
    spark.read
      .format(config.format)
      // .header(config.header)
      .option("header", config.header.toString)
      .schema(config.schema)
      .load(config.path)
  }
}
