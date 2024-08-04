package apps

import org.apache.spark.sql.{SparkSession, DataFrame}
import org.apache.spark.sql.functions.col
import config.{FileSourceConfig, FileTargetConfig}
import executor.ETLExecutor
import transformations.DataTransformation
import schemas.ExampleAppSchema

object MainApp extends App {
  val spark = SparkSession
    .builder()
    .master("local[*]")
    .appName("User Data ETL")
    .getOrCreate()

  // Define a custom transformation
  object CustomTransformation extends DataTransformation {
    def transform(dfs: List[DataFrame]): List[DataFrame] = {
      List(dfs.head.filter(col("Age") > 25))
    }
  }

  // TODO: list of schemas, not just one
  val sourceConfig =
    FileSourceConfig("csv", "input.csv", ExampleAppSchema.schema)
  val targetConfig = FileTargetConfig("csv", "output")

  ETLExecutor.execute(
    spark,
    List(sourceConfig),
    List(targetConfig),
    CustomTransformation
  )
}
