package dev.estudos.kotlin.collections

import dev.estudos.kotlin.exercicios.formatToBrazil
import dev.estudos.kotlin.exercicios.sumByBigDecimal
import java.math.BigDecimal
import java.math.RoundingMode

fun main() {

    val calculadora = CalculadoraLucroLiquido()

    calculadora.calcularPrevisaoLucroLiquido()

    println("_______________________________________________________")
    println("Calculando imposto por Estado:")

    println(calculadora.impostoPorEstado.joinToString("\n") {
        " - UF: ${it.uf} | Mensalidade: ${it.valorMensalidade.formatToBrazil()} | Aliquota: ${it.aliquotaImposto.formatToBrazil()} | Imposto: ${it.valorImposto.formatToBrazil()}"
    })

    println("_______________________________________________________")
    println("Total Mensalidade: ${calculadora.totalMensalidade.formatToBrazil()} ")
    println("Total Imposto: ${calculadora.totalImposto.formatToBrazil()} ")
    println("Alíquota Média: ${calculadora.aliquotaMedia.formatToBrazil()} ")
    println("Previsão do Lucro Liquido: ${calculadora.previsaoLucro.formatToBrazil()} ")
}

class UFImposto(
    val uf: String,
    val valorMensalidade: BigDecimal,
    var aliquotaImposto: BigDecimal = BigDecimal.ZERO,
    var valorImposto: BigDecimal = BigDecimal.ZERO
)

class  CalculadoraLucroLiquido {

    var totalMensalidade : BigDecimal = BigDecimal.ZERO
    var impostoPorEstado : List<UFImposto> = listOf()
    var aliquotaMedia : BigDecimal = BigDecimal.ZERO
    var totalImposto: BigDecimal = BigDecimal.ZERO
    var totalAliquota: BigDecimal = BigDecimal.ZERO
    var previsaoLucro: BigDecimal = BigDecimal.ZERO

    // Previsao Lucro Liquido = Total Mensalidade - Imposto para o Estado
    fun calcularPrevisaoLucroLiquido(): BigDecimal {
        totalMensalidade = calcularTotalMensalidade()
        impostoPorEstado = calcularImpostosPorEstado()

        totalImposto = impostoPorEstado.sumByBigDecimal { it.valorImposto }.setScale(2, RoundingMode.HALF_EVEN)
        totalAliquota = impostoPorEstado.sumByBigDecimal { it.aliquotaImposto }.setScale(2, RoundingMode.HALF_EVEN)

        aliquotaMedia = totalAliquota.divide(impostoPorEstado.size.toBigDecimal(), 2, RoundingMode.HALF_EVEN)

        previsaoLucro = (totalMensalidade - totalImposto).setScale(2, RoundingMode.HALF_EVEN)

        return previsaoLucro
    }

    fun calcularTotalMensalidade(): BigDecimal {
        val totalMensalidade = alunos.sumByBigDecimal { it.valorMensalidade }

        return totalMensalidade
    }

    // Imposto para o Estado = Valor Mensalidade * Aliquota do Imposto
    fun calcularImpostosPorEstado(): List<UFImposto> {
        val impostoPorEstado = alunos
            .map { UFImposto(it.uf, it.valorMensalidade) }
            .groupBy { it.uf }
            .map { (key, value) ->
                // converte {key: SP, [ {valorImposto: ...}, {valorImposto: ...} ]}
                UFImposto(key, value.map { it.valorMensalidade }.reduce { acc, valorImposto -> acc + valorImposto })
            }
            .map { calcularImposto(it) }

        return impostoPorEstado
    }

    fun calcularImposto(ufImposto: UFImposto): UFImposto {
        val estado = estados.find { estado -> estado.uf == ufImposto.uf } ?: estados.find { it.uf == "XX" }!!

        ufImposto.aliquotaImposto = estado.aliquotaImposto
        ufImposto.valorImposto = (ufImposto.valorMensalidade * ufImposto.aliquotaImposto).movePointLeft(2)

        return ufImposto
    }

}