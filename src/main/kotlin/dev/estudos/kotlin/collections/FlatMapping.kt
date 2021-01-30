package dev.estudos.kotlin.collections

fun main() {
    val todasAsDisciplinas = cursos.flatMap { it.disciplinas }

    println(todasAsDisciplinas.joinToString("\n"))
}