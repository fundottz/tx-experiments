package com.example.txmongo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
class TxmongoApplication

fun main(args: Array<String>) {
	runApplication<TxmongoApplication>(*args)
}
