package dev.estudos.kotlin.collections

import org.junit.jupiter.api.Test

class CollectionsSortingTest {

    @Test
    fun exemploComSortedBy() {

        val alunosOrdenadosPorNome = alunos.sortedBy { it.nome }

        println(alunosOrdenadosPorNome.joinToString("\n"))

    }

    @Test
    fun exemploComSortedByDesc() {

        alunos.sortedByDescending { it.valorMensalidade }.let {
            println(it.joinToString("\n"))
        }

    }

    @Test
    fun exemploComSortedWithUtilizandoComparatorAnonimo() {
        val comparator = object: Comparator<Aluno> {

            override fun compare(aluno1: Aluno?, aluno2: Aluno?): Int {
                val compareUf = aluno1?.uf?.compareTo(aluno2?.uf ?: "")

                if (compareUf != 0) {
                    return compareUf!!
                }

                val compareCidade = aluno1?.cidade?.compareTo(aluno2?.cidade ?: "")

                if (compareCidade != 0) {
                    return compareCidade!!
                }

                val compareNome = aluno1?.nome?.compareTo(aluno2?.nome ?: "")

                return compareNome!!
            }

        }

        alunos.sortedWith(comparator).let {
            println(it.joinToString("\n"))
        }

    }

    @Test
    fun exemploComSortedWithUtilizandoLambda() {

        alunos.sortedWith { aluno1, aluno2 ->
            var resultado = aluno1?.uf?.compareTo(aluno2?.uf ?: "")
            if (resultado == 0) {
                resultado = aluno1?.cidade?.compareTo(aluno2?.cidade ?: "")

                if (resultado == 0) {
                    resultado = aluno1?.nome?.compareTo(aluno2?.nome ?: "")
                }
            }
            resultado!!
        }.let {
            println(it.joinToString("\n"))
        }

    }

}