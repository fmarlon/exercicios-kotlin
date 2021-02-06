package dev.estudos.kotlin.json

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import dev.estudos.kotlin.pessoas.Endereco
import dev.estudos.kotlin.pessoas.Pessoa
import java.io.Reader
import java.time.LocalDate


class LeitorJson {

    fun read() {
        // this.javaClass.getResourceAsStream("/arquivos-json/enderecos.json")
    }

    fun readArray(s: String): JsonArray {
        return JsonArray().apply {
            add("")
            add("")
        }
    }

    fun readObject(s: String): JsonObject {
        return JsonObject()
    }

}