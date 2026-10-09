package com.example.exibirpatrimoniosactivity.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DesktopWindows
import androidx.compose.material.icons.filled.Laptop
import androidx.compose.ui.graphics.vector.ImageVector

enum class TipoPatrimonio(val icone: ImageVector, val descricao: String) {
    NOTEBOOK(Icons.Default.Laptop, "Notebook"),
    COMPUTADOR(Icons.Default.DesktopWindows, "Computador")
}

data class Patrimonio(
    val id: Int,
    val codigo: String,
    val item: String,
    val serie: String,
    val descricao: String,
    val localizacao: String,
    val prateleira: String,
    val tipo: TipoPatrimonio
)
