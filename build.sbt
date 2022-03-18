import Dependencies._

ThisBuild / scalaVersion     := "3.1.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.sangkon"
ThisBuild / organizationName := "sangkon"

lazy val root = (project in file("."))
  .settings(
    name := "Scala Seed Project",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.11" % Test,
    libraryDependencies += "org.json4s" %% "json4s-native" % "4.0.4",
    libraryDependencies += "org.json4s" %% "json4s-jackson" % "4.0.4",
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
