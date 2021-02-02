package dev.estudos.kotlin.collections

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CalculadoraLucroLiquidoTest {

    /**
     * Total Mensalidade: 2.225,00
     * Total Imposto: 60,41
     * Alíquota Média: 2,79
     * Previsão do Lucro Liquido: 2.164,59
     */
    @Test
    fun calcularPrevisaoLucroLiquido() {
        val calculadora = CalculadoraLucroLiquido()

        val lucroLiquido = calculadora.calcularPrevisaoLucroLiquido()

        assertEquals("2164.59".toBigDecimal(), lucroLiquido, "Lucro liquido")
        assertEquals("2225.00".toBigDecimal(), calculadora.totalMensalidade, "Total Mensalidade")
        assertEquals("60.41".toBigDecimal(), calculadora.totalImposto, "Total Imposto")
        assertEquals("2.79".toBigDecimal(), calculadora.aliquotaMedia, "Aliquota Media")
    }
}