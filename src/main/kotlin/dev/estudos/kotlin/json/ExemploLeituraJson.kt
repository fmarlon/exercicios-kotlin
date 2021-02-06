package dev.estudos.kotlin.json

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import dev.estudos.kotlin.pessoas.Endereco
import dev.estudos.kotlin.pessoas.Pessoa
import java.io.Reader
import java.time.LocalDate

fun main() {

    val classLoader = Thread.currentThread().contextClassLoader

    val inputStream = classLoader.getResourceAsStream("pessoas.json")

    val jsonArray = Gson().fromJson(inputStream.reader(), JsonArray::class.java)

    val pessoas2 = lerPessoasDeFormaImperativa(jsonArray)

    println(pessoas2.joinToString("\n"))

    val pessoas = lerPessoasFuncionalmente(jsonArray)

    println(pessoas.joinToString("\n"))

}

fun lerPessoasDeFormaImperativa(jsonArray: JsonArray): List<Pessoa> {
    val pessoas2 = mutableListOf<Pessoa>()

    for (jsonElement in jsonArray) {
        val it = jsonElement as JsonObject
        if (it.get("ativo").asBoolean != true) {
            continue
        }
        val pessoa = Pessoa().apply {
            id = it.get("id").asInt
            nome = it.get("nome").asString
            cpf = it.get("cpf").asString
            rg = it.get("rg").asString
            dataNascimento = LocalDate.parse(it.get("dataNascimento").asString)
            altura = it.get("altura").asBigDecimal
            peso = it.get("peso").asBigDecimal
            endereco = it.getAsJsonObject("endereco").let { Endereco(
                it.get("logradouro").asString,
                it.get("numero").asString,
                it.get("bairro").asString,
                it.get("cidade").asString,
                it.get("uf").asString
            )
            }
        }
        pessoas2.add(pessoa)
    }
    return pessoas2
}

private fun lerPessoasFuncionalmente(jsonArray: JsonArray): List<Pessoa> {
    val pessoas = jsonArray
        .filter { (it as JsonObject).get("ativo").asBoolean }
        .map {
            it as JsonObject
            Pessoa().apply {
                id = it.get("id").asInt
                nome = it.get("nome").asString
                cpf = it.get("cpf").asString
                rg = it.get("rg").asString
                dataNascimento = LocalDate.parse(it.get("dataNascimento").asString)
                altura = it.get("altura").asBigDecimal
                peso = it.get("peso").asBigDecimal
                endereco = it.getAsJsonObject("endereco").let {
                    Endereco(
                        it.get("logradouro").asString,
                        it.get("numero").asString,
                        it.get("bairro").asString,
                        it.get("cidade").asString,
                        it.get("uf").asString
                    )
                }
            }
        }
    return pessoas
}
