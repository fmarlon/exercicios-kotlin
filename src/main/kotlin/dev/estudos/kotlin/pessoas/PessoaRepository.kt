package dev.estudos.kotlin.pessoas

import dev.estudos.kotlin.exercicios.isNumber

class PessoaRepository {

    val lista = mutableListOf<Pessoa>()
    var lastId : Int = 0

    fun add(pessoa: Pessoa): Int {
        // padrao cpf: 000.000.000-00
        val regexCpfFormatado = Regex("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")

        if (regexCpfFormatado.matches(pessoa.cpf)) {
            // cpf ok
        } else {
            val cpf = pessoa.cpf
            if (cpf.length != 11 || !cpf.isNumber()) {
                throw ValidationException("CPF deve ter 11 dígitos numericos")
            }
        }
        val newId = ++lastId
        val pessoaIncluida = pessoa.copy(id = newId)
        lista.add(pessoaIncluida)
        return newId
    }

    fun getById(id: Int): Pessoa? {
        return lista.find { it.id == id }
    }


}