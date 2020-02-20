package com.example.txmongo

import org.springframework.data.mongodb.repository.MongoRepository

interface QuoteRepository : MongoRepository<Quote, String>