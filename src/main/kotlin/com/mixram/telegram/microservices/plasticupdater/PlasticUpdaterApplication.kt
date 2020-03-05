package com.mixram.telegram.microservices.plasticupdater

import com.mixram.telegram.microservices.utilities.logging.logger
import org.apache.logging.log4j.Logger
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication
class PlasticUpdaterApplication

val log: Logger = logger(PlasticUpdaterApplication::class)

fun main(args: Array<String>) {
    pushVersion2Env()

    runApplication<PlasticUpdaterApplication>(*args)

    log.info("PRODUCT_VERSION ==> '${System.getProperty("product.version")}'")
    log.info("PRODUCT_VERSION_FULL ==> '${System.getProperty("product.version.full")}'")
}

/**
 * @since 0.0.1.0
 */
private fun pushVersion2Env() {
    val p: Properties = Properties()
    p.load(PlasticUpdaterApplication::class.java.getResourceAsStream("/META-INF/build-info.properties"))
    val ver: List<String> = p.getProperty("build.version")
            .split("[.]".toRegex())
    check(ver.size >= 4) { "Wrong build.version=${p.getProperty("build.version")}!" }

    System.setProperty("product.version", "${ver[0]}.${ver[1]}")
    System.setProperty("product.version.full", "${ver[0]}.${ver[1]}.${ver[2]}.${ver[3]}")
}
