package com.example.exibirpatrimoniosactivity.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// O app foi desenhado com fundo branco e barras azuis, então usa só o esquema claro.
private val InvScanColorScheme = lightColorScheme(
    primary = InvScanBlue,
    onPrimary = Color.White,
    background = Color.White,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black
)

@Composable
fun ExibirPatrimoniosActivityTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = InvScanColorScheme,
        typography = Typography,
        content = content
    )
}
