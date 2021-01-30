package dev.estudos.kotlin.exercicios

import kotlin.math.pow

/**
Escreva um algoritmo que leia três números inteiros e positivos (A, B, C) e calcule a seguinte expressão:
  D = (R + S) / 2
onde:
  R = (A + B)²
  S = (B + C)²
*/

fun main() {
    println("""
    Informe os valores A, B e C para calcular a formula abaixo:
      D = (R + S) / 2
    onde:
      R = (A + B)²    e    S = (B + C)² 
    """.trimIndent())

    val a = readInt("Informe o valor de A: ")
    val b = readInt("Informe o valor de B: ")
    val c = readInt("Informe o valor de C: ")

    val d = Exercicio2.calcularD(a, b, c)

    println("""
        
        -----------------------------
        D = $d
        -----------------------------
        
    """.trimIndent())
}

object Exercicio2 {

    fun calcularD(a: Int, b: Int, c: Int): Int {
        val r = calcularR(a, b)
        val s = calcularS(b, c)
        val d = calcularD(r, s)

        return d
    }

    fun calcularD(r: Int, s: Int): Int {
        return (r + s) / 2
    }

    fun calcularR(a: Int, b: Int): Int {
        return (a + b).toDouble().pow(2).toInt()
    }

    fun calcularS(b: Int, c: Int): Int {
        return (b + c).toDouble().pow(2).toInt()
    }

}