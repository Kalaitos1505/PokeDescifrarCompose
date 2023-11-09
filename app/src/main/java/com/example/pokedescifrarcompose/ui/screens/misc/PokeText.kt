package com.example.pokedescifrarcompose.ui.screens.misc

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.example.pokedescifrarcompose.ui.theme.pixeloidSansFamily

@Composable
fun PokeText(text: String, fontSize: TextUnit, color: Color, shadowColor: Color, modifier: Modifier) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = pixeloidSansFamily,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold,
            color = color,
            shadow = Shadow(
                color = shadowColor,
                offset = Offset(1.5f, 1.5f),
            )
        ),
        modifier = modifier
    )
}