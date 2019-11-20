package com.vah.kots

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotsApplication

fun main(args: Array<String>) {
	runApplication<KotsApplication>(*args)
}
