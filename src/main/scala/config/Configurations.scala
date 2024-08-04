package config
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

sealed trait DataTargetConfig

case class FileTargetConfig(
    format: String,
    path: String
) extends DataTargetConfig

case class TableTargetConfig(
    databaseName: String,
    tableName: String
) extends DataTargetConfig
