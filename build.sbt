name := "learning_scalaz"

version := "0.1"

scalaVersion := "2.12.6"

val scalazVersion = "7.2.22"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % scalazVersion,
  "org.scalaz" %% "scalaz-effect" % scalazVersion,
//  "org.scalaz" %% "scalaz-typelevel" % scalazVersion,
  "org.scalaz" %% "scalaz-scalacheck-binding" % "7.2.22-scalacheck-1.14" % "test"
)

scalacOptions ++= Seq("-encoding", "UTF-8", "-feature")

initialCommands in console := "import scalaz._, Scalaz._"

initialCommands in console in Test := "import scalaz._, Scalaz._, scalacheck.ScalazProperties._, scalacheck.ScalazArbitrary._,scalacheck.ScalaCheckBinding._"