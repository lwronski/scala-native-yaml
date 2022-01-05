
import org.virtuslab.yaml.*

object Main extends App {
  case class Language(kind: String, platform: String) derives YamlCodec
  val yaml = """|kind: Scala
                |platform: Native
                |""".stripMargin

  pprint.pprintln(yaml.as[Language])
}
