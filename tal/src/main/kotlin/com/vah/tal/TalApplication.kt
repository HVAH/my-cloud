package com.vah.tal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TalApplication

fun main(args: Array<String>) {
    runApplication<TalApplication>(*args)
}
