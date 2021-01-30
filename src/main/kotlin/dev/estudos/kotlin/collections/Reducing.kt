package dev.estudos.kotlin.collections

import dev.estudos.kotlin.exercicios.formatToBrazil
import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    val totalMensalidade = alunos
        .map { it.valorMensalidade }
        .reduce { acc, valorMensalidade -> acc + valorMensalidade }

    println("Total Mensalidade: ${totalMensalidade.formatToBrazil()} ")

    // Previsao Lucro Liquido = Total Mensalidade - Imposto para o Estado
    // Imposto para o Estado = Valor Mensalidade * Aliquota do Imposto

    println("_______________________________________________________")
    println("Calculando imposto por Estado:")

    val impostoPorEstado = alunos
        .map { UFImposto(it.uf, it.valorMensalidade) }
        .groupBy { it.uf }
        .entries.map {
            // converte {key: SP, [ {valorImposto: ...}, {valorImposto: ...} ]}
            UFImposto(it.key, it.value.map { it.valorMensalidade }.reduce{ acc, valorImposto -> acc + valorImposto })
        }
        .map(::calcularImposto)

    println(impostoPorEstado.joinToString("\n") {
        " - UF: ${it.uf} | Mensalidade: ${it.valorMensalidade.formatToBrazil()} | Aliquota: ${it.aliquotaImposto.formatToBrazil()} | Imposto: ${it.valorImposto.formatToBrazil()}"
    })

    val totalImposto = impostoPorEstado.map { it.valorImposto }.reduce{ acc, valor -> acc + valor }
    val totalAliquota = impostoPorEstado.map { it.aliquotaImposto }.reduce{ acc, valor -> acc + valor }
    val aliquotaMedia = totalAliquota.divide(alunos.size.toBigDecimal(), 4, RoundingMode.HALF_EVEN)

    println("_______________________________________________________")
    println("Total Imposto: ${totalImposto.formatToBrazil()} ")
    println("Alíquota Média: ${aliquotaMedia.formatToBrazil()} ")
}

class UFImposto(
    val uf: String,
    val valorMensalidade: BigDecimal,
    var aliquotaImposto: BigDecimal = BigDecimal.ZERO,
    var valorImposto: BigDecimal = BigDecimal.ZERO
)

fun calcularImposto(ufImposto: UFImposto): UFImposto {
    val estado = estados.find { estado -> estado.uf == ufImposto.uf } ?: estados.find { it.uf == "XX" }!!

    ufImposto.aliquotaImposto = estado.aliquotaImposto
    ufImposto.valorImposto = (ufImposto.valorMensalidade * ufImposto.aliquotaImposto).movePointLeft(2)

    return ufImposto
}