package executor

import org.apache.spark.sql.{SparkSession, DataFrame}
import config.{
  DataSourceConfig,
  DataTargetConfig,
  FileSourceConfig,
  TableSourceConfig,
  FileTargetConfig,
  TableTargetConfig
}
import transformations.DataTransformation
import io.{FileReader, FileWriter}

object ETLExecutor {
  def execute(
      spark: SparkSession,
      sourceConfigs: List[DataSourceConfig],
      targetConfigs: List[DataTargetConfig],
      transformation: DataTransformation
  ): Unit = {

    try {
      val readers = sourceConfigs.map { case fileConfig: FileSourceConfig =>
        new FileReader(spark).read(fileConfig)
      // Add cases for other config types if needed
      }

      val transformedData = transformation.transform(readers)

      targetConfigs.zip(transformedData).foreach {
        case (fileConfig: FileTargetConfig, df) =>
          new FileWriter(spark).write(df, fileConfig)
        // Add cases for other config types if needed
      }
    } finally {

      spark.stop()
    }
  }
}
