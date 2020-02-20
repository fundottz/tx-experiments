package com.example.txmongo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringRunner
import org.testcontainers.containers.GenericContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import java.math.BigDecimal
import java.util.*

@Testcontainers
@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class TransactionalServiceTest {

//    @Autowired
//    lateinit var quoteRepository: QuoteRepository

    @Autowired
    lateinit var transactionalService: TransactionalService

    @Container
    private val mongo: GenericContainer<Nothing> =
            GenericContainer<Nothing>("mongo:4.2.3")
                    .withExposedPorts(27017)

    @BeforeEach
    fun `should check that database is empty`(){
//        assertThat(quoteRepository.count()).isEqualTo(0)
    }

    @Test
    fun `should save transactionally two documents in different databases`() {
        assertThat(mongo.isRunning).isTrue()

        val doc1 = Quote(UUID.randomUUID().toString(), "GAZP", BigDecimal.valueOf(1))
        transactionalService.save(doc1)

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}