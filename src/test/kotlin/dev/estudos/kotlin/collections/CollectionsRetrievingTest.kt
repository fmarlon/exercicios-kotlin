package dev.estudos.kotlin.collections

import org.junit.jupiter.api.Test
import dev.estudos.kotlin.exercicios.compareTo
import java.math.BigDecimal

class CollectionsRetrievingTest {

    @Test
    fun retrieveFirstItems() {
        val aluno0 = alunos[0]

        val alunoFirst = alunos.first()
        val alunoFirstMG = alunos.first { it.uf == "MG" }
        val alunoFirstAM = alunos.firstOrNull { it.uf == "AM" }
        val alunoByElementAt0 = alunos.elementAt(0)

        println("aluno[0]: " + aluno0)
        println("alunoFirst: " + alunoFirst)
        println("alunoFirstMG: " + alunoFirstMG)
        println("alunoFirstAM: " + alunoFirstAM)
        println("alunoByElementAt0: " + alunoByElementAt0)
    }

    @Test
    fun retrieveLastItems() {
        val alunoLastByIndex = alunos[alunos.size - 1]

        val alunoLast = alunos.last()
        val alunoLastMG = alunos.last { it.uf == "MG" }

        println("alunoLastByIndex: " + alunoLastByIndex)
        println("alunoLast: " + alunoLast)
        println("alunoLastMG: " + alunoLastMG)
    }

    @Test
    fun searchItems() {
        val anyAlunoDePortoAlegre = alunos.any { it.cidade == "Porto Alegre" }
        val anyAlunoDeConfins = alunos.any { it.cidade == "Confins" }

        val allAlunosTemMensalidadeMaiorQue50 = alunos.all { it.valorMensalidade > 50.00 }
        val allAlunosMoramEmMG = alunos.all { it.uf == "MG" }

        val noneAlunosComMensalidadeIgualAZero = alunos.none { it.valorMensalidade == BigDecimal.ZERO }
        val noneAlunosQueMoraEmSP = alunos.none { it.uf == "SP" }

        println("anyAlunoDePortoAlegre: $anyAlunoDePortoAlegre")
        println("anyAlunoDeConfins: $anyAlunoDeConfins")
        println("allAlunosTemMensalidadeMaiorQue50: $allAlunosTemMensalidadeMaiorQue50")
        println("allAlunosMoramEmMG: $allAlunosMoramEmMG")

        println("noneAlunosComMensalidadeIgualAZero: $noneAlunosComMensalidadeIgualAZero")
        println("noneAlunosQueMoraEmSP: $noneAlunosQueMoraEmSP")

    }

    @Test
    fun filterItems() {
        val alunosDeConfis = alunos.filter { it.cidade == "Confins" }
        val alunosDeBH = alunos.filter { it.cidade == "Belo Horizonte" }
        val countAlunosDeBH = alunos.count { it.cidade == "Belo Horizonte" }

        val alunosDeBHAPartirDoIndex5 = alunos.filterIndexed{ index, it -> index > 5 && it.cidade == "Belo Horizonte" }

        println("alunosDeConfis: $alunosDeConfis")
        println("alunosDeBH: \n${alunosDeBH.joinToString(separator = "\n")}")
        println("countAlunosDeBH: $countAlunosDeBH")
        println("alunosDeBHAPartirDoIndex5: ${alunosDeBHAPartirDoIndex5.joinToString(separator = "\n")}")
    }

    @Test
    fun findItems() {
        val alunoQueMoraEmConfins = alunos.find { it.cidade == "Confins" }
        val alunoQueMoraEmBH = alunos.find { it.cidade == "Belo Horizonte" }
        val ultimoAlunoQueMoraEmBH = alunos.findLast { it.cidade == "Belo Horizonte" }

        println("alunosDeConfis: $alunoQueMoraEmConfins")
        println("alunoQueMoraEmBH: $alunoQueMoraEmBH")
        println("ultimoAlunoQueMoraEmBH: $ultimoAlunoQueMoraEmBH")
    }

}