package dev.estudos.kotlin.pessoas

import org.slf4j.LoggerFactory

/**
 * REGRA1: Deve ter pelo menos duas palavras
 * REGRA2: Deve ter pelo menos uma palavra com mais de 2 letras
 * REGRA3: Só aceitar alguma palavra com uma letra se o nome tiver mais de 2 palavras
 * REGRA4: A primeira palavra deve ter mais de uma letra e iniciar maiuscula
 * REGRA5: Palavras com mais de duas letras devem iniciar com maiuscula
 * REGRA6: Aceitar palavras em minusculo somente no meio do nome
 */
object ValidadorNome {

    val logging = LoggerFactory.getLogger(ValidadorNome::class.java)

    fun validar(nome: String): Boolean {
        val regras = mapOf<String, (palavras: List<String>) -> Boolean>(
            "REGRA1: Deve ter pelo menos duas palavras" to this::regra1,
            "REGRA2: Deve ter pelo menos uma palavra com mais de 2 letras" to this::regra2,
            "REGRA3: Só aceitar alguma palavra com uma letra se o nome tiver mais de 2 palavras" to this::regra3,
            "REGRA4: A primeira palavra deve ter mais de uma letra e iniciar maiuscula" to this::regra4,
            "REGRA5: Palavras com mais de duas letras devem iniciar com maiuscula" to this::regra5,
            "REGRA6: Aceitar palavras em minusculo somente no meio do nome" to this::regra6
         )

        logging.info("Iniciando algoritmo para validarNome | nome: $nome")

        val palavras = nome.split(" ")
        for ((key, value) in regras) {
            val resultado = value.invoke(palavras)

            logging.info("Executando: $key | resultado: $resultado")

            if (!resultado) {
                return false
            }
        }

        logging.info("Finalizando algoritmo para validarNome | nome: $nome")

        return true
    }

    // Aceitar palavras em minusculo somente no meio do nome
    // estrategia: verificar se primeira e ultima palavras sao minusculas, em vez de verificar no meio
    private fun regra6(palavras: List<String>): Boolean {
        if (palavras.first()[0].isLowerCase()) {
            return false
        } else if (palavras.last()[0].isLowerCase()) {
            return false
        }
        return true
    }

    private fun regra5(palavras: List<String>) = palavras
        .filter { it.length > 2 }
        .all { it[0].isUpperCase() }

    private fun regra4(palavras: List<String>): Boolean {
        val primeiraPalavra = palavras[0]
        if (!(primeiraPalavra.length > 1 && primeiraPalavra[0].isUpperCase())) {
            return false
        }
        return true
    }

    private fun regra3(palavras: List<String>): Boolean {
        if (palavras.any { it.length == 1 }) {
            if (!(palavras.size > 2)) {
                return false
            }
        }
        return true
    }

    private fun regra2(palavras: List<String>): Boolean {
        if (!palavras.any { it.length > 2 }) {
            return false
        }
        return true
    }

    // Deve ter pelo menos duas palavras
    private fun regra1(palavras: List<String>): Boolean {
        if (palavras.size < 2) {
            return false
        }
        return true
    }

}