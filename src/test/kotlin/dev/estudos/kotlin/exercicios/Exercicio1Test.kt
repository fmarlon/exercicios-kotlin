package dev.estudos.kotlin.exercicios

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class Exercicio1Test {

    @Test
    @DisplayName("Distancia entre os pontos P(1,10) e P(30,50) deve ser 49.40")
    fun cenario1() {
        // given
        val p1 = Exercicio1.Ponto(1, 10)
        val p2 = Exercicio1.Ponto(30, 50)

        // when
        val resultado = Exercicio1.calcularDistancia(p1, p2)

        // then
        assertEquals(49.41, resultado)
    }

    @Test
    @DisplayName("Distancia entre os pontos P(-15,-50) e P(10,80) deve ser 132.38")
    fun cenario2() {
        val p1 = Exercicio1.Ponto(-15, -50)
        val p2 = Exercicio1.Ponto(10, 80)

        val resultado = Exercicio1.calcularDistancia(p1, p2)

        assertEquals(132.38, resultado)
    }

}