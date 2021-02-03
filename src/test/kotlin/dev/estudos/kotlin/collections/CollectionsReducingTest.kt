package dev.estudos.kotlin.collections

import org.junit.jupiter.api.Test
import java.math.BigDecimal

class CollectionsReducingTest {

    @Test
    fun exemploReduceComSomaDasMensalidades() {
        val valorReducing = alunos.map { it.valorMensalidade }.reduce { acc, it -> acc + it }

        println(valorReducing)
    }

    @Test
    fun exemploReduceAlunoComMenorMensalidade() {
        val alunoComMenorMensalidade = alunos.reduce { acc, it ->
            if (acc.valorMensalidade < it.valorMensalidade) acc
            else it
        }

        println(alunoComMenorMensalidade)
    }

    @Test
    fun exemploReduceAlunoComMaiorMensalidade() {
        val alunoComMaiorMensalidade = alunos.reduce { acc, it ->
            if (acc.valorMensalidade > it.valorMensalidade) acc
            else it
        }

        println(alunoComMaiorMensalidade)
    }

    @Test
    fun exemploReduceTotalMensalidadeRegiaoSudeste() {
        val totalMensalidadeSudeste = alunos
            .filter { aluno ->
                estados.any { estado -> estado.uf == aluno.uf && estado.regiao.codigo == "SE" }
            }
            .map { it.valorMensalidade }
            .reduce { acc, it -> acc + it }

        println(totalMensalidadeSudeste)
    }

    @Test
    fun exemploFoldTotalMensalidadeRegiaoSudeste() {
        val totalMensalidadeSudeste = alunos
            .filter { aluno ->
                estados.any { estado -> estado.uf == aluno.uf && estado.regiao.codigo == "SE" }
            }
            .fold(BigDecimal.ZERO) { acc, aluno -> acc + aluno.valorMensalidade }

        println(totalMensalidadeSudeste)
    }

}