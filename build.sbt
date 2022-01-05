scalaVersion := "3.1.0"

resolvers += Resolver.sonatypeRepo("snapshots")

// Set to false or remove if you want to show stubs as linking errors
nativeLinkStubs := true

enablePlugins(ScalaNativePlugin)

libraryDependencies ++= List(
  "org.virtuslab" %%% "scala-yaml" % "0.0.4+22-d6ccdc59-SNAPSHOT",
  "com.lihaoyi" % "pprint_native0.4_2.13" % "0.7.1"

)
