package com.example.exibirpatrimoniosactivity.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exibirpatrimoniosactivity.data.PerfilUsuario
import com.example.exibirpatrimoniosactivity.ui.components.IconSection
import com.example.exibirpatrimoniosactivity.ui.components.ValueField
import com.example.exibirpatrimoniosactivity.ui.theme.Dimens
import com.example.exibirpatrimoniosactivity.ui.theme.ExibirPatrimoniosActivityTheme

@Composable
fun PerfilScreen(
    modifier: Modifier = Modifier,
    perfil: PerfilUsuario = PerfilUsuario(),
    quantidadeSelos: Int = 5
) {
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
        // Dados pessoais
        IconSection(icon = Icons.Default.Person, contentDescription = "Perfil") {
            ValueField(label = "Nome", valor = perfil.nome)
            ValueField(label = "Email", valor = perfil.email)
            ValueField(label = "Telefone", valor = perfil.telefone)
        }

        // Descrição / observações
        IconSection(icon = Icons.Default.Edit, contentDescription = "Editar") {
            ValueField(label = "Descrição / Observações", valor = perfil.descricao, height = 80.dp)
        }

        // Localização
        IconSection(icon = Icons.Default.LocationOn, contentDescription = "Localização") {
            ValueField(label = "Endereço", valor = perfil.endereco)
            ValueField(label = "Cidade", valor = perfil.cidade)
        }

        // Selos
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(quantidadeSelos) {
                Icon(
                    imageVector = Icons.Default.Shield,
                    contentDescription = "Selo",
                    tint = Color.Black,
                    modifier = Modifier.size(48.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PerfilScreenPreview() {
    ExibirPatrimoniosActivityTheme {
        PerfilScreen()
    }
}
