package com.digital.digitalapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("com.digital.pocapp.database.repositories")
@EntityScan("com.digital.pocapp.database.tables")
class DigitalAppApplication

fun main(args: Array<String>) {
	runApplication<DigitalAppApplication>(*args)
}
