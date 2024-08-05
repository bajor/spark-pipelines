package io
import org.apache.spark.sql.types.StructType

sealed trait DataTargetConfig

case class FileTargetConfig(
    format: String,
    path: String
) extends DataTargetConfig

case class TableTargetConfig(
    databaseName: String,
    tableName: String
) extends DataTargetConfig
