package dev.estudos.kotlin.exercicios

import java.lang.NumberFormatException
import java.math.BigDecimal
import java.text.DecimalFormat
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

fun BigDecimal.formatToBrazil(): String {
    return DecimalFormat("#,##0.00").format(this)
}

fun String.isNumber(): Boolean {
    return this.toLongOrNull() != null
}

public inline fun <T> Iterable<T>.sumByBigDecimal(selector: (T) -> BigDecimal): BigDecimal {
    var sum: BigDecimal = BigDecimal.ZERO
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

public operator fun BigDecimal.compareTo(other: Int) = this.compareTo(other.toBigDecimal())
public operator fun BigDecimal.compareTo(other: Double) = this.compareTo(other.toBigDecimal())

