package com.example.txmongo

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TransactionalService(val quoteRepository: QuoteRepository) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Transactional
    fun save(doc1: Quote) {
        updateQuote(doc1)
        updateMarketData()
    }

    private fun updateQuote(quote: Quote) {
        logger.info("Updating quote {}", quote)

        quoteRepository.save(quote)
    }

    protected fun updateMarketData() {
        throw RuntimeException("Ooops... Fail...")
    }
}
