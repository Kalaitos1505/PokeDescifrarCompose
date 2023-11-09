package com.example.pokedescifrarcompose.ui.screens.title

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.pokedescifrarcompose.R
import com.example.pokedescifrarcompose.ui.theme.PokeRed


@Composable
fun TitleImage(modifier: Modifier) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = R.drawable.ic_pokeball),
        contentDescription = "pokeballMainScreen",
        tint = PokeRed
    )
}
