### Current state of repo 
This is some initial idea on how repo with multiple Spark Apps with common read and write functions might look like. List of remaining essential functionalities in  section below.

### Run given app
```
sbt compile

sbt

run ExampleApp
```

### Repo structure:
```
├── src/
│   ├── main/
│   │   └── scala/
│   │       ├── executor/
│   │       │   └── Executor.scala
│   │       ├── io/
│   │       │   ├── FileReader.scala
│   │       │   ├── FileWriter.scala
│   │       │   ├── SourceConfig.scala
│   │       │   └── TargetConfig.scala
│   │       ├── schemas/
│   │       │   └── ExampleAppSchema.scala
│   │       ├── spark/
│   │       │   └── SparkConfig.scala
│   │       ├── transformations/
│   │       │   └── Transformation.scala
│   │       └── apps/
│   │           └── ExampleApp.scala
│   └── test/
└── build.sbt
```

### TODO
```
 Add write mode
 FileTargetConfig = FileSourceConfig and TableSourceConfig = TableTargetConfig, unify them
 Infer if its list of dataframes to be writter/read or just one

 Tests:
    - Validate that your file readers correctly interpret paths and formats, and that any options (like header in FileSourceConfig) are respected.
    - For transformations, provide DataFrames constructed with known data and verify the output against expected DataFrames.
    - Test edge cases such as empty DataFrames, DataFrames with missing columns, or DataFrames with unexpected data types.

    - Test the integration of readers, transformations, and writers within the ETLExecutor to ensure they interact correctly.
    - Validate the end-to-end process from reading data, transforming it, and writing the output to ensure the ETL process completes without errors and produces expected results.
```