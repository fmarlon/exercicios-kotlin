package dev.estudos.kotlin.exercicios

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import kotlin.system.exitProcess

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

    val calculadoraDeDias : CalculadoraDeDias

    print("Forma de cálculo (R: Rudimentar, A: Apurada (Padrão) - considera ano bisexto): ")
    calculadoraDeDias = when(readLine()) {
        "R" -> CalculadoraDiasRudimentar
        "A", "" -> CalculadoraDiasApurada
        else -> {
            println("Tipo de Cálculo Inválido. O programa será encerrado")
            exitProcess(0)
        }
    }

    val totalDias = calculadoraDeDias.calcular(localDate)

    println("""
        ------------------------------
        Tipo Calculo: ${calculadoraDeDias.javaClass.simpleName}
        ------------------------------
        Total de Dias: $totalDias
    """.trimIndent())
}

interface CalculadoraDeDias {

    fun calcular(date: LocalDate): Int

}

object CalculadoraDiasRudimentar: CalculadoraDeDias {

    override fun calcular(date: LocalDate): Int {
        // diasTotal = date.days + (date.month * 30) + ((currentYear - date.year) * 365)
        // Exemplo: 10/05/1990
        // diasTotal = 10 + (5 * 30) + ((2021 - 1990) * 365)

        val currentYear = LocalDate.now().year
        val diasTotal = date.dayOfMonth + (date.monthValue * 30) + (currentYear - date.year) * 365

        return diasTotal
    }

}

object CalculadoraDiasApurada: CalculadoraDeDias {

    override fun calcular(date: LocalDate): Int {
        val chronoUnit = ChronoUnit.DAYS.between(date, LocalDate.now())

        return chronoUnit.toInt()
    }

}