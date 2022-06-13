ThisBuild / scalaVersion := "3.1.2"
ThisBuild / version := "1.0.0"
ThisBuild / organization := "com.sangkon"
ThisBuild / organizationName := "sangkon"

lazy val root = (project in file("."))
  .settings(
    name := "Practice Scala",
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.12",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12" % "test",
    libraryDependencies += "org.json4s" %% "json4s-native" % "4.0.5",
    libraryDependencies += "org.json4s" %% "json4s-jackson" % "4.0.5"
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
