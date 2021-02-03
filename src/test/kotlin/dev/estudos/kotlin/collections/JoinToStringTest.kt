package dev.estudos.kotlin.collections

import dev.estudos.kotlin.exercicios.formatToBrazil
import org.junit.jupiter.api.Test

class JoinToStringTest {

    @Test
    fun exemploDoUsoDaFuncaoJoinToString() {

        alunos.joinToString(separator = "\n", prefix = "[\n", postfix = "\n]") {
            "${it.nome} (${it.valorMensalidade.formatToBrazil()})"
        }.let {
            println(it)
        }

    }

}