package com.example.pokedescifrarcompose.ui.screens.end

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pokedescifrarcompose.entities.GameViewModel
import com.example.pokedescifrarcompose.entities.Pokemon
import com.example.pokedescifrarcompose.repositories.PokemonRepository
import com.example.pokedescifrarcompose.ui.screens.PokeDescifrarUI
import com.example.pokedescifrarcompose.ui.screens.misc.PokeText
import com.example.pokedescifrarcompose.ui.theme.pixeloidSansFamily

@Composable
fun GameEndScreen(
    endWords: Map<Pokemon, Boolean>,
    endScore: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Fin del juego",
            style = TextStyle(
                fontSize = 40.sp,
                fontFamily = pixeloidSansFamily
            )
        )
        Text(
            text = "Puntuación: ${endScore.toString()}",
            style = TextStyle(
                fontSize = 25.sp,
                fontFamily =  pixeloidSansFamily
            )
        )
        endWords.forEach() { entry ->
            Text(
                text = "${entry.key.name} : ${entry.value}",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = pixeloidSansFamily
                )
            )
        }
    }
}

@Composable
@Preview
fun GameEndScreenPrev() {
        GameEndScreen(
            endScore = 20,
            endWords = emptyMap()
        )
    }