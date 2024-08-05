package io
import org.apache.spark.sql.types.StructType

sealed trait DataSourceConfig

case class FileSourceConfig(
    format: String,
    path: String,
    schema: StructType,
    header: Boolean = true
) extends DataSourceConfig

case class TableSourceConfig(
    databaseName: String,
    tableName: String
) extends DataSourceConfig
