package com.example.exibirpatrimoniosactivity.navigation

const val ARG_ID_PATRIMONIO = "id"

/** Todas as rotas do app em um só lugar. */
sealed class Rotas(val rota: String) {

    data object Inicio : Rotas("inicio")

    data object Patrimonio : Rotas("patrimonio/{$ARG_ID_PATRIMONIO}") {
        fun criar(id: Int): String = "patrimonio/$id"
    }

    data object Perfil : Rotas("perfil")
}
