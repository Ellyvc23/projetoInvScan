package com.example.exibirpatrimoniosactivity.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import com.example.exibirpatrimoniosactivity.ui.theme.Dimens

/**
 * Seção "ícone à esquerda + conteúdo à direita".
 * Usada na tela de patrimônio e no perfil.
 */
@Composable
fun IconSection(
    icon: ImageVector,
    contentDescription: String,
    modifier: Modifier = Modifier,
    iconTint: Color = Color.Black,
    iconSize: Dp = Dimens.SectionIconSize,
    content: @Composable ColumnScope.() -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.width(Dimens.SectionIconColumn),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = iconTint,
                modifier = Modifier.size(iconSize)
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = Dimens.SectionGap),
            verticalArrangement = Arrangement.spacedBy(Dimens.FieldSpacing),
            content = content
        )
    }
}

/** Linha de ação da tela inicial: botão de ícone à esquerda + conteúdo (campo ou botão). */
@Composable
fun IconActionRow(
    icon: ImageVector,
    contentDescription: String,
    onIconClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Dimens.SectionGap),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onIconClick,
            modifier = Modifier.size(Dimens.ActionIconButton)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = Color.Black,
                modifier = Modifier.size(Dimens.ActionIconSize)
            )
        }
        Box(modifier = Modifier.weight(1f)) {
            content()
        }
    }
}

/** Botão principal do app (usa a cor primária do tema). */
@Composable
fun InvScanButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(Dimens.ButtonHeight)
    ) {
        Text(text)
    }
}
