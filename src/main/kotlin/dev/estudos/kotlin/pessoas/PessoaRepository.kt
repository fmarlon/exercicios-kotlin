package dev.estudos.kotlin.pessoas

import dev.estudos.kotlin.exercicios.isNumber

class PessoaRepository {

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
        val pessoaIncluida = pessoa.copy(id = newId)
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

    /**
     * Deve ter pelo menos duas palavras
     * Deve ter pelo menos uma palavra com mais de 2 letras
     * Só aceitar alguma palavra com uma letra se o nome tiver mais de 2 palavras
     * A primeira palavra deve ter mais de uma letra e iniciar maiuscula
     * Palavras com mais de duas letras devem iniciar com maiuscula
     */
    fun validarNome(nome: String): Boolean {
        val palavras = nome.split(" ")

        // Deve ter pelo menos duas palavras
        if (palavras.size < 2) {
            return false
        }

        // Deve ter pelo menos uma palavra com mais de 2 letras
        if (palavras.any { it.length > 2 }) {
            return true
        }

        // Só aceitar alguma palavra com uma letra se o nome tiver mais de 2 palavras
        if (palavras.any { it.length == 1 }) {
            if (palavras.size > 2) {
                return true
            }
        }

        // A primeira palavra deve ter mais de uma letra e iniciar maiuscula
        val primeiraPalavra = palavras[0]
        if (primeiraPalavra.length > 0 && primeiraPalavra[0].isUpperCase()) {
            return true
        }

        return true
    }


}