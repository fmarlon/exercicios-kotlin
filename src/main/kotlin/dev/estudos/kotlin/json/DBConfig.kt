package dev.estudos.kotlin.json

import com.google.gson.annotations.SerializedName

data class DBConfig(
    var host: String = "",
    var port: String = "",
    @SerializedName("database")
    var databaseName: String = "",
    @SerializedName("username")
    var userName: String = "",
    var password: String = ""
)
