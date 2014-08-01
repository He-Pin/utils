name := "json"

version := "1.0"

organization := "us.sosia"

libraryDependencies ++=Seq(
  "com.fasterxml.jackson.core" % "jackson-core" % "2.4.1.1",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.4.1.3",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.4.1"
)

