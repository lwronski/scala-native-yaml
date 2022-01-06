scalaVersion := "3.1.0"

resolvers += Resolver.sonatypeRepo("snapshots")


enablePlugins(ScalaNativePlugin)

libraryDependencies ++= List(
  "org.virtuslab" %%% "scala-yaml" % "0.0.4+23-cb6aab7b-SNAPSHOT",
  "com.lihaoyi" % "pprint_native0.4_2.13" % "0.7.1"
)


nativeConfig ~= {_.withMode(scalanative.build.Mode.releaseFull).withLTO(scalanative.build.LTO.thin)}
