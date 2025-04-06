name := "social-network"
version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.12"

libraryDependencies ++= Seq(
  guice,
  javaJdbc,
  "mysql" % "mysql-connector-java" % "8.0.33",
  "com.typesafe.play" %% "play-json" % "2.9.4",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.13.0",
  "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % "2.13.0"
)

// Add dependency resolution rules
ThisBuild / libraryDependencySchemes += "org.scala-lang.modules" %% "scala-xml" % "always"

// Force the latest version of Twirl API
dependencyOverrides += "org.playframework.twirl" %% "twirl-api" % "2.0.3"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
