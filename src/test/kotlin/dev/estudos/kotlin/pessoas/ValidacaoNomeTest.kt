package dev.estudos.kotlin.pessoas

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class ValidacaoNomeTest {

    val repository = PessoaRepository()

    @ParameterizedTest
    @CsvSource(
        "A L,false",
        "A L Sousa,false",
        "Ada Li,true",
        "Ada li,false",
        "Ada L,false",
        "Ada L Sousa,true",
        "Ada de Sousa,true"
    )
    fun testNome(nome: String, resultadoEsperado: Boolean) {
        val resultadoAtual = repository.validarNome(nome)

        assertEquals(resultadoEsperado, resultadoAtual)
    }

}