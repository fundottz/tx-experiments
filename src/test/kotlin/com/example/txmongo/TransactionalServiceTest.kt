package com.example.txmongo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.testcontainers.containers.GenericContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import java.math.BigDecimal
import java.util.*

@Testcontainers
@ExtendWith(SpringExtension::class)
@SpringBootTest
class TransactionalServiceTest {

    @Autowired
    lateinit var quoteRepository: QuoteRepository

    @Autowired
    lateinit var transactionalService: TransactionalService

    @Container
    private val mongo: GenericContainer<Nothing> =
            GenericContainer<Nothing>("mongo:4.2.3")
                    .withExposedPorts(27017)

    @BeforeEach
    fun `database should be ready and empty`(){
        assertThat(quoteRepository.count()).isEqualTo(0)
        assertThat(mongo.isRunning).isTrue()
    }

    @Test
    fun `should rollback saving document when inside transaction appears exception`() {
        val doc1 = Quote(UUID.randomUUID().toString(), "GAZP", BigDecimal.valueOf(1))
        transactionalService.save(doc1)

        assertThat(quoteRepository.count()).isEqualTo(0)
    }
}