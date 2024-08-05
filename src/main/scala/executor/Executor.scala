package executor

import org.apache.spark.sql.{SparkSession, DataFrame}
import spark.SparkConfig

import transformations.DataTransformation
import io.{
  DataSourceConfig,
  DataTargetConfig,
  FileTargetConfig,
  FileReader,
  FileWriter,
  FileSourceConfig,
  TableSourceConfig,
  TableTargetConfig
}

object Executor {
  def execute(
      sparkConfig: SparkConfig,
      sourceConfigs: List[DataSourceConfig],
      targetConfigs: List[DataTargetConfig],
      transformation: DataTransformation
  ): Unit = {
    val spark = sparkConfig.getSparkSession

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
