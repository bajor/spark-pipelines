name := "MySparkApp"

version := "0.1"

scalaVersion := "2.13.10"


libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.4.3",
  "org.apache.spark" %% "spark-sql" % "3.4.3",
)


inThisBuild(
  List(
    scalaVersion := "2.13.10",
    scalafmtOnCompile := true
  )
)