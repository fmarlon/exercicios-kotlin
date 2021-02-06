package dev.estudos.kotlin.json

import com.google.gson.*
import com.google.gson.reflect.TypeToken
import dev.estudos.kotlin.pessoas.Pessoa
import java.lang.reflect.Type
import java.time.LocalDate

object LocalDateDeserializer : JsonDeserializer<LocalDate> {

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): LocalDate {
        return LocalDate.parse(json!!.asString)
    }

}

fun main() {

    val gson = GsonBuilder()
        .registerTypeAdapter(LocalDate::class.java, LocalDateDeserializer)
        .create()

    val classLoader = Thread.currentThread().contextClassLoader

    val inputStream = classLoader.getResourceAsStream("pessoas.json")
    val reader = inputStream.reader()

    val type: Type = object: TypeToken<List<Pessoa>>(){}.type
    val pessoas: List<Pessoa> = gson.fromJson(reader, type)

    println(pessoas.joinToString("\n"))

}

private fun exemploLeituraJsonParaBeanSimples() {
    val classLoader = Thread.currentThread().contextClassLoader

    val inputStream = classLoader.getResourceAsStream("configuracao.json")

    val dbConfig = Gson().fromJson(inputStream.reader(), DBConfig::class.java)

    println(dbConfig)
}