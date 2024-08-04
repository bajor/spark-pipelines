

sbt

sbt:my-project> runMain MainApp
sbt:my-project> runMain AnotherApp


my-project/
└── src/
    └── main/
        └── scala/
            └── com/
                └── example/
                    ├── MainApp.scala
                    └── AnotherApp.scala
You would use the fully qualified names like this:

To run MainApp:

scala
Skopiuj kod
sbt:my-project> runMain com.example.MainApp




MyScalaETLProject/
├── src/
│   ├── main/
│   │   └── scala/
│   │       ├── config/
│   │       │   └── Configurations.scala
│   │       ├── io/
│   │       │   ├── DataReader.scala
│   │       │   └── DataWriter.scala
│   │       ├── transformations/
│   │       │   └── DataTransformation.scala
│   │       ├── executor/
│   │       │   └── ETLExecutor.scala
│   │       └── apps/
│   │           ├── firstApp.scala
│   │           └── secondApp.scala
│   └── test/
└── build.sbt


# TODO FileTargetConfig = FileSourceConfig and TableSourceConfig = TableTargetConfig, unify them
# TODO: infer if its list of dataframes to be writter/read or just one
# TODO: provide schema for the input files!


# format
sbt scalafmt
have plugins.sbt in project/


# format imports on save
{
    "editor.formatOnSave": true,
    "[scala]": {
        "editor.defaultFormatter": "scalameta.metals"
    },
    "metals.formatOnSave": true,
    "metals.enable-organize-imports-on-save": true
}