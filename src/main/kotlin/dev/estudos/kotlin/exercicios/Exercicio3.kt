package dev.estudos.kotlin.exercicios

import java.time.LocalDate
import java.time.Period
import java.time.chrono.ChronoPeriod
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import kotlin.time.days

/**
  Faça um algoritmo que leia a data de nascimento de uma pessoa expressa no formato (DD/MM/AAAA),
  e mostre-a expressa apenas em dias (todos os dias de vida).
*/

fun main() {
    println("""
        Cálculo de dias de uma data de nascimento.
    """.trimIndent())

    print("Informe a data de nascimento (formato DD/MM/AAAA): ")
    val dataDigitada = readLine()

    val localDate = LocalDate.parse(dataDigitada, DateTimeFormatter.ofPattern("dd/MM/yyyy"))

    val totalDias = calcularDias(localDate)

    val totalDiasChonoUnit = calcularDiasComChronoUnit(localDate)

    println("""
        ------------------------------
        Total de Dias (Padrão): $totalDias
        ------------------------------
        Total de Dias (ChonoUnit): $totalDiasChonoUnit
    """.trimIndent())
}

fun calcularDias(date: LocalDate): Int {
    // diasTotal = date.days + (date.month * 30) + ((currentYear - date.year) * 365)
    // Exemplo: 10/05/1990
    // diasTotal = 10 + (5 * 30) + ((2021 - 1990) * 365)

    val currentYear = LocalDate.now().year
    val diasTotal = date.dayOfMonth + (date.monthValue * 30) + (currentYear - date.year) * 365

    return diasTotal
}

fun calcularDiasComChronoUnit(date: LocalDate): Int {
    val period = Period.between(date, LocalDate.now())

    val chronoUnit = ChronoUnit.DAYS.between(date, LocalDate.now())

    return chronoUnit.toInt()
}