# dante-scala-spark
Example project in SCALA to count the words in the Divine Comedy using Apache Spark
IntelliJ project files

## usage
- sbt package: to compile the project *or* select "sbt shell" from the bottom of the screen and write the "package" command
- spark-submit --master local[4] --class Dante target/.../dante....jar
