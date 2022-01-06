
import org.virtuslab.yaml.*

object Main extends App {

  case class Library(
    library: String,
    language: String,
    version: String,
    platforms: List[String],
  ) derives YamlCodec

  val yaml: String = """|library: scala-yaml
                        |language: Scala
                        |version: 3.1.0
                        |platforms: [JVM, JS, Native]
                        |""".stripMargin

  pprint.pprintln(yaml.as[Library], width = 30)
}
