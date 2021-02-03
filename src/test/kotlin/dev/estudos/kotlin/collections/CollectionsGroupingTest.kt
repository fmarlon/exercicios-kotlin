package dev.estudos.kotlin.collections

import org.junit.jupiter.api.Test

class CollectionsGroupingTest {

    @Test
    fun exemploGroupBy() {
        val alunosPorUf = alunos.groupBy { it.uf }

        alunosPorUf.forEach { uf, alunos ->
            println("UF: $uf (${alunos.size})  ------------------------------------------------------------")
            println(alunos.joinToString("\n") { "  $it" })
            println()
        }
    }

    @Test
    fun exemploGroupByPorCidade() {
        val alunosPorCidade = alunos.groupBy { "${it.cidade} - ${it.uf}" }

        alunosPorCidade.forEach { cidadeUf, alunos ->
            println("Cidade: $cidadeUf (${alunos.size})  ------------------------------------------------------------")
            println(alunos.joinToString("\n") { "  $it" })
            println()
        }
    }

    @Test
    fun exemploGroupByPorRegiao() {
        val alunosPorRegiao = alunos.groupBy { aluno ->
            val estado = estados.find { estado -> estado.uf == aluno.uf }
            estado?.regiao ?: Regiao("(Desconhecida)", "DESC")
        }

        alunosPorRegiao.forEach { regiao, alunos ->
            println("Regiao: $regiao (${alunos.size})  ------------------------------------------------------------")
            println(alunos.joinToString("\n") { "  $it" })
            println()
        }
    }

}