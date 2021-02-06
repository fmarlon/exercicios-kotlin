package dev.estudos.kotlin.pessoas

import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate

data class Pessoa (var id: Int? = null) {
    var nome: String = ""
    var cpf: String = ""
    var rg: String = ""
    var dataNascimento: LocalDate? = null
    var altura: BigDecimal? = null
    var peso: BigDecimal? = null
    var telefone : String = ""
    var endereco : Endereco = Endereco()

    // Formula: IMC = PESO / ALTURA²
    fun calcularIMC(): BigDecimal {
        if (peso == null) {
            throw IllegalStateException("Peso da pessoa indisponível")
        }
        if (altura == null) {
            throw IllegalStateException("Altura da pessoa indisponível")
        }
        return peso?.setScale(2)!!.divide(altura!!.pow(2), 2, RoundingMode.HALF_EVEN)
    }

    override fun toString(): String {
        return "Pessoa(id=$id, nome=$nome, cpf=$cpf)"
    }

}