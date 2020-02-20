package com.example.txmongo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document
data class Quote(@Id val id: String? = null, val instrument: String, val bid: BigDecimal)

@Document
data class MarketData(@Id val id: String? = null, val instrument: String, val name: String, val bid: BigDecimal)
