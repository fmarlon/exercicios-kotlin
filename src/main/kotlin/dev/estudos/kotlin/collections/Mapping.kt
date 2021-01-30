package dev.estudos.kotlin.collections

data class CursoDTO (val nome: String, val qtdDisciplinas: Int, val cargaHoraria: Int)

fun main() {
    val cursosDTOs = cursos.map {
        CursoDTO(
            it.nome,
            it.disciplinas.size,
            it.disciplinas.sumBy { it.cargaHoraria }
        )
    }

    println(cursosDTOs.joinToString("\n"))
}