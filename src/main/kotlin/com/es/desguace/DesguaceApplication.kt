package com.es.desguace

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import com.es.desguace.security.RSAKeysProperties

@SpringBootApplication
@EnableConfigurationProperties(RSAKeysProperties::class)
class DesguaceApplication

fun main(args: Array<String>) {
	runApplication<DesguaceApplication>(*args)
}
