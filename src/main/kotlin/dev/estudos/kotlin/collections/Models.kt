package dev.estudos.kotlin.collections

data class Curso (val nome: String, val disciplinas: List<Disciplina>)
data class Disciplina (val nome: String, val cargaHoraria: Int)

val cursos : List<Curso> = listOf(
    Curso(
        "Desenvolvimento Android",
        listOf(
            Disciplina("Kotlin", 20),
            Disciplina("Android", 60)
        )
    ),
    Curso(
        "React",
        listOf(
            Disciplina("HTML/CSS", 20),
            Disciplina("Java Script", 60),
            Disciplina("React", 90)
        )
    ),
    Curso(
        ".NET",
        listOf(
            Disciplina("C#", 30),
            Disciplina("Orientação a Objetos", 60),
            Disciplina("Visual Studio", 50)
        )
    ),
    Curso(
        "Java",
        listOf(
            Disciplina("Fundamentos", 20),
            Disciplina("Orientação a Objetos", 60),
            Disciplina("IDE Eclipse", 15)
        )
    ),
)
