package com.mixram.telegram.microservices.plasticupdater

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PlasticUpdaterApplication

fun main(args: Array<String>) {
    runApplication<PlasticUpdaterApplication>(*args)
}
