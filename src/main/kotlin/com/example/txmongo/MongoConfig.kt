package com.example.txmongo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDbFactory
import org.springframework.data.mongodb.MongoTransactionManager
import org.springframework.data.mongodb.config.AbstractMongoConfiguration

@Configuration
class MongoConfig : AbstractMongoConfiguration() {

    @Bean
    fun transactionManager(dbFactory: MongoDbFactory): MongoTransactionManager {
        return MongoTransactionManager(dbFactory)
    }

    override fun mongoClient(): com.mongodb.MongoClient {
        return com.mongodb.MongoClient("127.0.0.1", 27017)
    }

    override fun getDatabaseName(): String {
        return "test"
    }
}
