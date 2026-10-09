package com.example.exibirpatrimoniosactivity.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HeadsetMic
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exibirpatrimoniosactivity.data.Patrimonio
import com.example.exibirpatrimoniosactivity.data.PatrimonioMock
import com.example.exibirpatrimoniosactivity.ui.components.IconActionRow
import com.example.exibirpatrimoniosactivity.ui.components.InvScanButton
import com.example.exibirpatrimoniosactivity.ui.components.SearchField
import com.example.exibirpatrimoniosactivity.ui.theme.Dimens
import com.example.exibirpatrimoniosactivity.ui.theme.ExibirPatrimoniosActivityTheme

@Composable
fun InicioScreen(
    onPatrimonioClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    patrimonios: List<Patrimonio> = PatrimonioMock.lista,
    onLocalizar: () -> Unit = {},
    onLerCodigo: () -> Unit = {},
    onSolicitarApoio: () -> Unit = {}
) {
    var busca by rememberSaveable { mutableStateOf("") }
    var buscaLocalizacao by rememberSaveable { mutableStateOf("") }

    val filtrados = remember(busca, patrimonios) {
        patrimonios.filter {
            it.item.contains(busca, ignoreCase = true) ||
                it.codigo.contains(busca, ignoreCase = true)
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(
                horizontal = Dimens.ScreenPaddingHorizontal,
                vertical = Dimens.ScreenPaddingVertical
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimens.SectionGap)
    ) {
        val larguraConteudo = Modifier.fillMaxWidth(Dimens.ContentWidthFraction)

        // Pesquisa de patrimônios
        SearchField(
            value = busca,
            onValueChange = { busca = it },
            modifier = larguraConteudo,
            placeholder = "Pesquisar"
        )

        // Lista de patrimônios
        Column(
            modifier = larguraConteudo
                .border(Dimens.BorderWidth, Color.Gray, RoundedCornerShape(6.dp))
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            filtrados.forEach { patrimonio ->
                OutlinedButton(
                    onClick = { onPatrimonioClick(patrimonio.id) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(Dimens.ButtonHeight),
                    shape = RoundedCornerShape(Dimens.CornerRadius)
                ) {
                    Icon(
                        imageVector = patrimonio.tipo.icone,
                        contentDescription = patrimonio.tipo.descricao
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = patrimonio.item,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            if (filtrados.isEmpty()) {
                Text("Nenhum patrimônio encontrado")
            }
        }

        Spacer(Modifier.height(Dimens.SectionSpacing))

        // Localização + pesquisa
        IconActionRow(
            icon = Icons.Default.LocationOn,
            contentDescription = "Localizar patrimônio",
            onIconClick = onLocalizar,
            modifier = larguraConteudo
        ) {
            SearchField(
                value = buscaLocalizacao,
                onValueChange = { buscaLocalizacao = it }
            )
        }

        // Leitura de QR Code
        IconActionRow(
            icon = Icons.Default.QrCodeScanner,
            contentDescription = "Escanear código",
            onIconClick = onLerCodigo,
            modifier = larguraConteudo
        ) {
            InvScanButton(text = "Ler código", onClick = onLerCodigo)
        }

        // Atendimento
        IconActionRow(
            icon = Icons.Default.HeadsetMic,
            contentDescription = "Receber atendimento",
            onIconClick = onSolicitarApoio,
            modifier = larguraConteudo
        ) {
            InvScanButton(text = "Solicitar apoio", onClick = onSolicitarApoio)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InicioScreenPreview() {
    ExibirPatrimoniosActivityTheme {
        InicioScreen(onPatrimonioClick = {})
    }
}
