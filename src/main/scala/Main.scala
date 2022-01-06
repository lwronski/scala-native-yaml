
import org.virtuslab.yaml.*

object Main extends App {

  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
}

  case class Web(build: String, ports: List[String], volumes: List[String]) derives YamlCodec
  case class Redis(image: String) derives YamlCodec
  case class Services(web: Web, redis: Redis) derives YamlCodec
  case class Compose(version: String, services: Services) derives YamlCodec

  val yamlString =
    s"""version: "3.9"
       |services:
       |  web:
       |    build: .
       |    volumes:
       |      - .:/code
       |      - logvolume01:/var/log
       |    ports:
       |      - "5000:5000"
       |  redis:
       |    image: "redis:alpine"
       |""".stripMargin

   val data = Compose(
    version = "3.9",
    services = Services(
      web = Web(
        build = ".",
        ports = List("5000:5000"),
        volumes = List(".:/code", "logvolume01:/var/log")
      ),
      redis = Redis(
        image = "redis:alpine"
      )
    )
  )

  time {
    for(i <- 1 to 1000000) {
      yamlString.as[Compose].getOrElse(???)
    }
  }

  time {
    for(i <- 1 to 1000000) {
      data.asYaml
    }
  }
}
