package com.example.pokedescifrarcompose.ui.screens.title

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedescifrarcompose.ui.theme.PokeRed
import com.example.pokedescifrarcompose.ui.theme.pokeFont


@Composable
@Preview
fun TitleText() {
    Text(
        modifier = Modifier.padding(top = 75.dp),
        text= "DecodeMon",
        style = TextStyle(
            fontFamily = pokeFont,
            fontSize = 60.sp,
            color = PokeRed
        )
    )
}