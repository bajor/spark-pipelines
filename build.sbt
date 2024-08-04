name := "MySparkApp"

version := "0.1"

scalaVersion := "2.13.10"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.4.2",
  "org.apache.spark" %% "spark-sql" % "3.4.2"
)

inThisBuild(
  List(
    scalaVersion := "2.13.10", // or whatever Scala version you are using
    scalafmtOnCompile := true // This will format your code every time you compile
  )
)


// sbt-scalafmt_2.12_1.0/  
// sbt-scalafmt_2.12_1.0/  