package dev.estudos.kotlin.collections

fun main() {
    val resultado = cursos
        .filter { it.disciplinas.any { it.cargaHoraria < 25 } }
        .map { Curso(it.nome, disciplinas = it.disciplinas.filter { it.cargaHoraria < 25 }) }

    val printCursosComDisciplinas = resultado.joinToString(separator = "\n") {
        " - " + it.nome + ": " + it.disciplinas.joinToString(",") { it.nome }
    }

    println("Cursos encontrados: (${resultado.size}) \n$printCursosComDisciplinas")
}