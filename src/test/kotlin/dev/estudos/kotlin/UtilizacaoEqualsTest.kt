package dev.estudos.kotlin

import org.junit.jupiter.api.Test
import java.math.BigDecimal

class UtilizacaoEqualsTest {

    @Test
    fun testDeComparacaoComStrings() {
        // Java                        Kotlin
        // = (atribuição)              ||
        // == comparação referencia    compara conteudo do objeto (fun equals)
        // === nao existe              compara referencia

        val nome1 = StringBuilder("Frank").toString()
        val nome2 = StringBuilder("Frank").toString()

        println("nome1: ${nome1} | nome2: ${nome2}")

        println("nome1 == nome2: ${nome1 == nome2}")
        println("nome1 === nome2: ${nome1 === nome2}")
    }

    @Test
    fun testComBigDecimal() {
        val valor1 = "0".toBigDecimal()
        val valor2 = "0".toBigDecimal()

        println("valor1: ${valor1} | valor2: ${valor2}")

        println("valor1 == valor2: ${valor1 == valor2}")
        println("valor1 === valor2: ${valor1 === valor2}")
        println("valor1 === valor1: ${valor1 === valor1}")
        println("valor2 === valor2: ${valor2 === valor2}")
    }

    @Test
    fun testComBigDecimal2() {
        val valor1 = "1.401".toBigDecimal()
        val valor2 = "1.500".toBigDecimal()

        println("valor1: ${valor1} | valor2: ${valor2}")

        println("valor1 == valor2: ${valor1 == valor2}")
        println("valor1 === valor2: ${valor1 === valor2}")
        println("valor1 equals valor2: ${valor1.equals(valor2)}")
        println("valor1 compareTo valor2: ${valor1.compareTo(valor2)}")
        println("valor1 eq valor2: ${valor1 eq valor2}")
    }

}

infix fun BigDecimal.eq(other: BigDecimal): Boolean {
    return this.compareTo(other) == 0
}