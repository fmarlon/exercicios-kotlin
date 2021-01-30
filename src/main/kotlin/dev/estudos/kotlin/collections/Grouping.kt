package dev.estudos.kotlin.collections

import java.math.BigDecimal

data class Aluno (val nome: String, val cidade: String, val uf: String, val valorMensalidade : BigDecimal)
data class Estado (val nome: String, val uf: String, val regiao: Regiao, val aliquotaImposto: BigDecimal )
data class Regiao (val nome: String, val codigo: String)

val alunos = listOf(
    Aluno("Pedro", "São Paulo", "SP", BigDecimal("180.00")),
    Aluno("Nicolas", "São Paulo", "SP", BigDecimal("180.00")),
    Aluno("Thiago", "Campinas", "SP", BigDecimal("180.00")),
    Aluno("João", "Belo Horizonte", "MG", BigDecimal("150.00")),
    Aluno("Paulo", "Rio de Janeiro", "RJ", BigDecimal("170.00")),
    Aluno("Maria", "Confins", "MG", BigDecimal("180.00")),
    Aluno("Joana", "Recife", "PE", BigDecimal("180.00")),
    Aluno("Lucas", "São Luis", "MA", BigDecimal("145.00")),
    Aluno("Livia", "Belo Horizonte", "MG", BigDecimal("180.00")),
    Aluno("Fabricio", "Belo Horizonte", "MG", BigDecimal("200.00")),
    Aluno("Breno", "Belo Horizonte", "MG", BigDecimal("180.00")),
    Aluno("Bernando", "Nova York", "NY", BigDecimal("300.00"))
)

val estados = listOf(
    Estado("São Paulo", "SP", Regiao("Sudeste", "SE"), BigDecimal("2.00")),
    Estado("Rio de Janeiro", "RJ", Regiao("Sudeste", "SE"), BigDecimal("3.00")),
    Estado("Minas Gerais", "MG", Regiao("Sudeste", "SE"), BigDecimal("3.50")),
    Estado("Pernanbuco", "PE", Regiao("Nordeste", "NE"), BigDecimal("4.00")),
    Estado("Maranhão", "MA", Regiao("Nordeste", "NE"), BigDecimal("4.25")),
    Estado("(Desconhecido)", "XX", Regiao("(Desconhecida)", ""), BigDecimal.ZERO)
)

fun main() {
    printAlunosPorCidade()

    println()

    printAlunosPorEstado()

    println()

    printAlunosPorRegiao()
}

fun printAlunosPorCidade() {
    println("Alunos por Cidade: ")

    val alunosPorCidade = alunos.groupBy { it.cidade }

    val printString = alunosPorCidade.entries.joinToString("\n") {
        "  Cidade: ${it.key} | Aluno(s): ${it.value.map { it.nome }}"
    }

    println(printString)
}

fun printAlunosPorEstado() {
    println("Alunos por Estado: ")

    val alunosPorUf = alunos.groupBy { it.uf }

    val printString = alunosPorUf.entries.joinToString("\n") {
        "  UF: ${it.key} | Aluno(s): ${it.value.map { it.nome }}"
    }

    println(printString)
}

fun printAlunosPorRegiao() {
    println("Alunos por Regiao: ")

    val alunosPorRegiao = alunos.groupBy { aluno ->
        estados.find { estado -> estado.uf == aluno.uf }?.regiao ?: Regiao("(Desconhecida)", "XX")
    }

    val printString = alunosPorRegiao.entries.joinToString("\n") {
        "  Regiao: ${it.key.nome} (${it.key.codigo}) | Aluno(s): ${it.value.map { it.nome }}"
    }

    println(printString)
}