name := "learning_scalaz"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.22"

scalacOptions ++= Seq("-encoding", "UTF-8", "-feature")

initialCommands in console := "import scalaz._, Scalaz._"