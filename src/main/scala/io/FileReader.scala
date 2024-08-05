package io

import org.apache.spark.sql.{DataFrame, SparkSession}

class FileReader(spark: SparkSession) {
  def read(config: FileSourceConfig): DataFrame = {
    spark.read
      .format(config.format)
      .option("header", config.header.toString)
      .schema(config.schema)
      .load(config.path)
  }
}
