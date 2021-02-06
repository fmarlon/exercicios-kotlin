package dev.estudos.kotlin.json

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import dev.estudos.kotlin.pessoas.Endereco
import dev.estudos.kotlin.pessoas.Pessoa
import java.time.LocalDate

fun main() {

    val classLoader = Thread.currentThread().contextClassLoader
    val inputStream = classLoader.getResourceAsStream("pessoas.json")

    val jsonArray = Gson().fromJson(inputStream.reader(), JsonArray::class.java)

    val pessoas = jsonArray
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
                endereco = it.getAsJsonObject("endereco").let { Endereco(
                    it.get("logradouro").asString,
                    it.get("numero").asString,
                    it.get("bairro").asString,
                    it.get("cidade").asString,
                    it.get("uf").asString
                )}
            }
        }

    println(pessoas.joinToString("\n"))

}

class LeitorJson {

    fun read() {
        // this.javaClass.getResourceAsStream()
    }

    fun readArray(s: String): JsonArray {
        TODO("Implementar")
    }

    fun readObject(s: String): JsonObject {
        TODO("Implementar")
    }

}