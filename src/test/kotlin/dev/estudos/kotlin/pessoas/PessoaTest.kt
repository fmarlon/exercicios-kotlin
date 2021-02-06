package dev.estudos.kotlin.pessoas

import org.junit.jupiter.api.Test
import java.time.LocalDate
import kotlin.test.assertEquals

class PessoaTest {

    @Test
    fun calcularIMC_comApplyFunction() {
        val pessoa = Pessoa().apply {
            nome = "Frank Santos"
            cpf = "65651227334"
            peso = 65.toBigDecimal()
            altura = 1.69.toBigDecimal()
        }

        val imc = pessoa.calcularIMC()

        assertEquals(22.76.toBigDecimal(), imc)
    }

    @Test
    fun calcularIMC_comAlsoFunction() {
        val pessoa = Pessoa().also {
            it.nome = "Frank Santos"
            it.cpf = "65651227334"
            it.peso = 65.toBigDecimal()
            it.altura = 1.69.toBigDecimal()
        }

        val imc = pessoa.calcularIMC()

        assertEquals(22.76.toBigDecimal(), imc)
    }

    @Test
    fun calcularIMC_comRunFunction() {
        val imc = Pessoa().run {
            nome = "Frank Santos"
            cpf = "65651227334"
            peso = 65.toBigDecimal()
            altura = 1.69.toBigDecimal()

            calcularIMC()
        }

        assertEquals(22.76.toBigDecimal(), imc)
    }

    @Test
    fun calcularIMC_comLetFunction() {
        val imc = Pessoa().let { p ->
            p.nome = "Frank Santos"
            p.cpf = "65651227334"
            p.peso = 65.toBigDecimal()
            p.altura = 1.69.toBigDecimal()

            p.calcularIMC()
        }

        assertEquals(22.76.toBigDecimal(), imc)
    }

    @Test
    fun calcularIMC_comWithFunction() {
        val pessoa = Pessoa().apply {
            nome = "Frank Santos"
            cpf = "65651227334"
            peso = 65.toBigDecimal()
            altura = 1.69.toBigDecimal()
        }

        with(pessoa) {
            nome = "Frank M M dos Santos"
            dataNascimento = LocalDate.parse("1984-09-20")
        }

        val imc = pessoa.calcularIMC()

        assertEquals(22.76.toBigDecimal(), imc)
    }

}