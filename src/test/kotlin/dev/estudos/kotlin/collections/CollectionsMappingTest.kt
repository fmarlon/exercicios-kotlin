package dev.estudos.kotlin.collections

import org.junit.jupiter.api.Test

data class CursoResumoDTO (val nome: String, val qtdDisciplinas: Int)
data class CursoPosicaoDTO (val nome: String, val qtdDisciplinas: Int, val posicao: Int)

class CollectionsMappingTest {

    @Test
    fun exemplosDeUsoDaFuncaoMap() {
        val cursoResumoDTOs = cursos.map {
            CursoResumoDTO(it.nome, it.disciplinas.size)
        }

        println("Lista de Resumo de Cursos: ")
        println(cursoResumoDTOs.joinToString("\n"))
    }

    @Test
    fun exemplosDeUsoDaFuncaoMapIndexed() {
        val cursoPosicaoDTOs = cursos.mapIndexed { index, it ->
            CursoPosicaoDTO(it.nome, it.disciplinas.size, index + 1)
        }

        println("Lista de Cursos por Posição: ")
        println(cursoPosicaoDTOs.joinToString("\n"))
    }

    @Test
    fun exemploDeUsoFlatMap() {
        val todasAsDisciplinas = cursos.flatMap { it.disciplinas }.toSet()

        println("Todas as Disciplinas:")
        println(todasAsDisciplinas.joinToString("\n"))
    }


}