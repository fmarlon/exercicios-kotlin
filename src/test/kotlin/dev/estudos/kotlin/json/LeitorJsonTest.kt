package dev.estudos.kotlin.json

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class LeitorJsonTest {

    @Test
    fun readArray() {
        val leitor = LeitorJson()

        val jsonArray: JsonArray = leitor.readArray("/pessoas.json")

        assertEquals(2, jsonArray.size())
    }

    @Test
    fun readObject() {
        val leitor = LeitorJson()

        val jsonObj: JsonObject = leitor.readObject("/configuracao.json")

        assertNotNull(jsonObj)
        assertEquals("192.168.1.100", jsonObj.get("host").asString)
        assertEquals("1933", jsonObj.get("port").asString)
        assertEquals("clientes", jsonObj.get("database").asString)
        assertEquals("root", jsonObj.get("username").asString)
        assertEquals("teste", jsonObj.get("password").asString)

    }

}