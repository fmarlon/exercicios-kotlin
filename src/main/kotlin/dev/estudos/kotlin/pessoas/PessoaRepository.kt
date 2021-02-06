package dev.estudos.kotlin.pessoas

import dev.estudos.kotlin.exercicios.isNumber
import org.slf4j.LoggerFactory

class PessoaRepository {

    val logging = LoggerFactory.getLogger(PessoaRepository::class.java)

    val lista = mutableListOf<Pessoa>()
    var lastId : Int = 0

    fun add(pessoa: Pessoa): Int {

        if (!validarCpf(pessoa)) {
            throw ValidationException("CPF deve ter 11 dígitos numericos")
        }
        if (!validarNome(pessoa.nome)) {
            throw ValidationException("Nome inválido")
        }

        val newId = ++lastId
        pessoa.id = newId
        val pessoaIncluida = pessoa
        lista.add(pessoaIncluida)
        return newId
    }

    fun getById(id: Int): Pessoa? {
        return lista.find { it.id == id }
    }

    private fun validarCpf(pessoa: Pessoa): Boolean {
        // padrao cpf: 000.000.000-00
        val regexCpfFormatado = Regex("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")

        if (regexCpfFormatado.matches(pessoa.cpf)) {
            // cpf ok
        } else {
            val cpf = pessoa.cpf
            if (cpf.length != 11 || !cpf.isNumber()) {
                return false
            }
        }
        return true
    }

    fun validarNome(nome: String): Boolean {
        return ValidadorNome.validar(nome)
    }

}