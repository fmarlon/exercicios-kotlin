package dev.estudos.kotlin.exercicios

import java.lang.NumberFormatException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.system.exitProcess

fun readInt(msg: String): Int {
    print(msg)

    val valorDigitado = readLine()

    if (valorDigitado.isNullOrEmpty()) {
        println("Nenhum valor informado. O programa será encerrado.")
        exitProcess(0)
    }

    val valor = try {
        valorDigitado?.toInt()
    } catch(e: NumberFormatException) {
        println("Informe um valor correto!")
        return readInt(msg)
    }

    return valor!!
}

fun LocalDate.formatToBrazil(): String {
    return this.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
}