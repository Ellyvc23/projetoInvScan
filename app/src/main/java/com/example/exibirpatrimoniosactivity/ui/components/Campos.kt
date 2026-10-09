package com.example.exibirpatrimoniosactivity.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exibirpatrimoniosactivity.ui.theme.Dimens
import com.example.exibirpatrimoniosactivity.ui.theme.FieldBorder
import com.example.exibirpatrimoniosactivity.ui.theme.FieldLabel
import com.example.exibirpatrimoniosactivity.ui.theme.FieldPlaceholder

/** Caixa com borda arredondada: base de todos os campos de exibição. */
@Composable
fun OutlinedInfoBox(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: @Composable BoxScope.() -> Unit
) {
    val shape = RoundedCornerShape(Dimens.CornerRadius)
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(Dimens.BorderWidth, FieldBorder, shape)
            .background(Color.White, shape)
            .padding(contentPadding),
        contentAlignment = contentAlignment,
        content = content
    )
}

/** Campo com título em cima e valor embaixo (ex.: PATRIMÔNIO / 2-004321). */
@Composable
fun LabeledInfoBox(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    OutlinedInfoBox(modifier = modifier.height(Dimens.FieldHeight)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = label,
                color = FieldLabel,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.5.sp
            )
            Text(
                text = value,
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

/** Campo de valor único. Quando [valor] está vazio, mostra [label] como dica. */
@Composable
fun ValueField(
    label: String,
    modifier: Modifier = Modifier,
    valor: String = "",
    height: Dp = Dimens.FieldHeight
) {
    OutlinedInfoBox(
        modifier = modifier.height(height),
        contentAlignment = Alignment.CenterStart,
        contentPadding = PaddingValues(horizontal = 14.dp)
    ) {
        Text(
            text = valor.ifEmpty { label },
            color = if (valor.isEmpty()) FieldPlaceholder else Color.Black,
            fontSize = 15.sp
        )
    }
}

/** Campo de pesquisa padrão (lupa à esquerda). */
@Composable
fun SearchField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = ""
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        placeholder = { if (placeholder.isNotEmpty()) Text(placeholder) },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Pesquisar") },
        singleLine = true
    )
}
