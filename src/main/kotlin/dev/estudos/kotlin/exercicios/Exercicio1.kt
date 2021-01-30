package dev.estudos.kotlin.exercicios

import java.lang.NumberFormatException
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.system.exitProcess

/**
 * Construa um algoritmo que, tendo como dados de entrada dois pontos quaisquer no plano,
 * P(x1,y1) e P(x2,y2), escreva a distância entre eles. A fórmula que efetua tal cálculo é:
 * distancia = RAIZ_QUADRADA((x2 - x1)² + (y2 - y1)²)
 */
fun main() {
    println("""
        Programa para Calculo de distancia de dois pontos quaisquer em um plano: P(x1,y1) e P(x2,y2).
        Informe os pontos x1, y1, x2 e y2.
    """.trimIndent())

    val x1 = readInt(msg = "Digite o valor de x1: ")
    val y1 = readInt(msg = "Digite o valor de y1: ")
    val x2 = readInt(msg = "Digite o valor de x2: ")
    val y2 = readInt(msg = "Digite o valor de y2: ")

    val p1 = Ponto(x1, y1)
    val p2 = Ponto(x2, y2)

    val distancia = calcularDistancia(p1, p2)

    println("")
    println("Distancia Calculada: $distancia")
    println("")

    println("Programa terminado. Obrigado!!!")
}

fun calcularDistancia(p1: Ponto, p2: Ponto): Int {
    val x2MenosX1 = (p2.x - p1.x).toDouble()
    val y2MenosY1 = (p2.y - p1.y).toDouble()

    val distancia = sqrt(x2MenosX1.pow(2) + y2MenosY1.pow(2))

    return distancia.toInt()
}

class Ponto ( val x: Int, val y: Int )

