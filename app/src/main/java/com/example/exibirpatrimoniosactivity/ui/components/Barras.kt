package com.example.exibirpatrimoniosactivity.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exibirpatrimoniosactivity.ui.theme.Dimens
import com.example.exibirpatrimoniosactivity.ui.theme.InvScanWelcome

/** Barra superior padrão: título "InvScan" centralizado e mensagem opcional à direita. */
@Composable
fun InvScanTopBar(
    modifier: Modifier = Modifier,
    mensagem: String? = null
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .windowInsetsPadding(WindowInsets.statusBars)
            .height(Dimens.BarHeight)
            .padding(horizontal = Dimens.ScreenPaddingHorizontal),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "InvScan",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        )
        if (mensagem != null) {
            Text(
                text = mensagem,
                color = InvScanWelcome,
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
    }
}

/**
 * Item da barra inferior.
 * [rotaPadrao] é o padrão da rota (usado para marcar o item ativo) e
 * [destino] é a rota concreta para onde o clique navega.
 */
data class BarItem(
    val rotaPadrao: String,
    val destino: String,
    val icone: ImageVector,
    val descricao: String
)

@Composable
fun InvScanBottomBar(
    itens: List<BarItem>,
    rotaAtual: String?,
    onNavigate: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .windowInsetsPadding(WindowInsets.navigationBars)
            .height(Dimens.BarHeight),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        itens.forEach { item ->
            val selecionado = item.rotaPadrao == rotaAtual
            IconButton(onClick = { onNavigate(item.destino) }) {
                Icon(
                    imageVector = item.icone,
                    contentDescription = item.descricao,
                    tint = if (selecionado) Color.White else Color.White.copy(alpha = 0.6f),
                    modifier = Modifier.size(Dimens.BarIconSize)
                )
            }
        }
    }
}
