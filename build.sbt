import Dependencies._

lazy val zioVersion = "1.0.0-RC10-1"

lazy val `refined-circe` = (project in file("."))
  .settings(
    inThisBuild(Seq(
      scalaVersion := "2.12.8",
      version := "0.1.0-SNAPSHOT",
      organization := "com.github.DmytroOrlov"
    )),
    addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3"),
    addCompilerPlugin(("org.scalameta" % "paradise" % "3.0.0-M11").cross(CrossVersion.full)),
    libraryDependencies ++= Seq(
      "eu.timepit" %% "refined" % "0.9.8",
      "io.circe" %% "circe-refined" % "0.11.1",

      "dev.zio" %% "zio" % zioVersion,
      "dev.zio" %% "zio-interop-cats" % "1.3.1.0-RC3",
      "io.monix" %% "monix" % "3.0.0-RC3",
      "org.typelevel" %% "cats-core" % "2.0.0-M4",
      "org.typelevel" %% "cats-mtl-core" % "0.5.0",
      "org.typelevel" %% "cats-tagless-macros" % "0.8",
      scalaTest % Test,
      scalaCheck % Test
    ),
    scalacOptions += "-Ypartial-unification"
  )
