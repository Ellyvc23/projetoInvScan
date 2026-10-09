package com.example.exibirpatrimoniosactivity.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exibirpatrimoniosactivity.data.Patrimonio
import com.example.exibirpatrimoniosactivity.data.PatrimonioMock
import com.example.exibirpatrimoniosactivity.ui.components.IconSection
import com.example.exibirpatrimoniosactivity.ui.components.LabeledInfoBox
import com.example.exibirpatrimoniosactivity.ui.components.OutlinedInfoBox
import com.example.exibirpatrimoniosactivity.ui.theme.Dimens
import com.example.exibirpatrimoniosactivity.ui.theme.ExibirPatrimoniosActivityTheme
import com.example.exibirpatrimoniosactivity.ui.theme.InvScanIconBlue

@Composable
fun PatrimonioScreen(
    patrimonio: Patrimonio?,
    modifier: Modifier = Modifier
) {
    if (patrimonio == null) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Patrimônio não encontrado")
        }
    } else {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    horizontal = Dimens.ScreenPaddingHorizontal,
                    vertical = Dimens.ScreenPaddingVertical
                ),
            verticalArrangement = Arrangement.spacedBy(Dimens.SectionSpacing)
        ) {
            // Identificação
            IconSection(
                icon = patrimonio.tipo.icone,
                contentDescription = patrimonio.tipo.descricao
            ) {
                LabeledInfoBox("PATRIMÔNIO", patrimonio.codigo)
                LabeledInfoBox("ITEM", patrimonio.item)
                LabeledInfoBox("SÉRIE", patrimonio.serie)
            }

            // Descrição
            OutlinedInfoBox(
                contentAlignment = Alignment.CenterStart,
                contentPadding = PaddingValues(12.dp)
            ) {
                Text(
                    text = patrimonio.descricao,
                    color = Color.Black,
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    textAlign = TextAlign.Start
                )
            }

            // Localização
            IconSection(
                icon = Icons.Default.LocationOn,
                contentDescription = "Localização",
                iconTint = InvScanIconBlue
            ) {
                LabeledInfoBox("LOCALIZAÇÃO", patrimonio.localizacao)
                LabeledInfoBox("PRATELEIRA", patrimonio.prateleira)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PatrimonioScreenPreview() {
    ExibirPatrimoniosActivityTheme {
        PatrimonioScreen(patrimonio = PatrimonioMock.lista.first())
    }
}
