package transformations

import org.apache.spark.sql.DataFrame

trait DataTransformation {
  def transform(dfs: List[DataFrame]): List[DataFrame]
}
