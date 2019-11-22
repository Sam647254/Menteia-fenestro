javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

lazy val root = (project in file(".")).
  settings(
    name := "Menteia fenestro",
    version := "0.1",
    scalaVersion := "2.13.1",
    retrieveManaged := true,
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-core" % "1.2.0",
    libraryDependencies += "com.amazon.alexa" % "ask-sdk-core" % "2.20.2",
    libraryDependencies += "com.amazon.alexa" % "ask-sdk-lambda-support" % "2.20.2",
    libraryDependencies += "com.amazon.alexa" % "ask-sdk" % "2.20.2"
  )

assemblyMergeStrategy in assembly := {
  {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x => MergeStrategy.first
  }
}
