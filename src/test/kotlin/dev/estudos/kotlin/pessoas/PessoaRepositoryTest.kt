package dev.estudos.kotlin.pessoas

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PessoaRepositoryTest {

    val repository = PessoaRepository()

    @Test
    fun adicionarPessoaComCpfInvalido() {
        val pessoa = Pessoa(1, "Teste", "11111")

        assertThrows( ValidationException::class.java,
            { repository.add(pessoa) }
        )
    }

    @Test
    fun adicionarPessoaComCpfComLetras() {
        val pessoa = Pessoa(1, "Teste", "123456789AA")

        assertThrows( ValidationException::class.java,
            { repository.add(pessoa) }
        )
    }

    @Test
    fun adicionarPessoaComCpfValidoComMascaraDeveAceitar() {
        val pessoa = Pessoa(nome= "Teste de Cpf Valido Com Mascara", cpf = "656.512.273-34")

        val id = repository.add(pessoa)

        repository.getById(id).let {
            assertNotNull(it)
            assertEquals(pessoa.nome, it?.nome)
            assertEquals(pessoa.cpf, it?.cpf)
        }
    }

    @Test
    fun adicionarPessoaComCpfValidoComMascaraInvalidaDeveDarErro() {
        val pessoa = Pessoa(nome= "Teste de Cpf Valido Com Mascara", cpf = "65.6.512-27334")

        assertThrows( ValidationException::class.java,
            { repository.add(pessoa) }
        )
    }

    @Test
    fun adicionarPessoaComCpfValidoDeveAdicionarComSucesso() {
        val pessoa = Pessoa(nome = "Teste", cpf = "65651227334")

        val idPessoa = repository.add(pessoa)

        val pessoaAdicinada = repository.getById(idPessoa)

        assertNotNull(pessoaAdicinada)
        assertEquals(1, pessoaAdicinada?.id)
        assertEquals("Teste", pessoaAdicinada?.nome)
        assertEquals("65651227334", pessoaAdicinada?.cpf)
    }


}