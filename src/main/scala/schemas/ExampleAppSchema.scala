package schemas

import org.apache.spark.sql.types.{
  StructType,
  StructField,
  StringType,
  IntegerType
}

object ExampleAppSchema {
  val schema: StructType = StructType(
    Array(
      StructField("UserID", IntegerType, nullable = false),
      StructField("Name", StringType, nullable = true),
      StructField("Age", IntegerType, nullable = true),
      StructField("Country", StringType, nullable = true)
    )
  )
}
