scalaVersion := "2.10.2"

libraryDependencies ++= Seq("commons-io" % "commons-io" % "2.4")

assemblyMergeStrategy in assembly := {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x => MergeStrategy.first
}