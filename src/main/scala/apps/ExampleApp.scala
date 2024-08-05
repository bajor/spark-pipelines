package apps

import org.apache.spark.sql.{SparkSession, DataFrame}
import org.apache.spark.sql.functions.col
import spark.{SparkConfig, LocalSparkConfig}
import io.{FileSourceConfig, FileTargetConfig}
import executor.Executor
import transformations.DataTransformation
import schemas.ExampleAppSchema

object ExampleApp extends App {
  val sparkConfig: SparkConfig = new LocalSparkConfig("ExampleApp")

  // Define a custom transformation
  object CustomTransformation extends DataTransformation {
    def transform(dfs: List[DataFrame]): List[DataFrame] = {
      List(dfs.head.filter(col("Age") > 25))
    }
  }

  val sourceConfig =
    FileSourceConfig("csv", "input.csv", ExampleAppSchema.schema)
  val targetConfig = FileTargetConfig("csv", "output")

  Executor.execute(
    sparkConfig,
    List(sourceConfig),
    List(targetConfig),
    CustomTransformation
  )
}
