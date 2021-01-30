package dev.estudos.kotlin.exercicios

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

/**
Faça um algoritmo que leia a idade de uma pessoa expressa em dias e mostre-a expressa em anos, meses e dias.
*/

fun main() {
    println("""
        
        Programa para retornar uma data com base na quantidade de dias totais.
        
    """.trimIndent())

    val qtdDias = readInt("Informe a qtd de dias: ")

    val localDate = converterDiasParaData(qtdDias)
    val dataFormatada = localDate.formatToBrazil()
    val qtdAnos = ChronoUnit.YEARS.between(localDate, LocalDate.now()).toInt()

    println("""
        Data Calculada: ${dataFormatada} (${qtdAnos} anos)
    """.trimIndent())
}

private fun converterDiasParaData(qtdDias: Int): LocalDate {
    val date = LocalDate.now().minusDays(qtdDias.toLong())

    return date
}