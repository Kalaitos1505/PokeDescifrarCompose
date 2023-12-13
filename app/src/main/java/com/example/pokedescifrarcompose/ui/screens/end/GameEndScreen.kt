package com.example.pokedescifrarcompose.ui.screens.end

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedescifrarcompose.R
import com.example.pokedescifrarcompose.data.entities.Pokemon
import com.example.pokedescifrarcompose.ui.screens.game.GameButton
import com.example.pokedescifrarcompose.ui.theme.pixeloidSansFamily

@Composable
fun GameEndScreen(
    endWords: Map<Pokemon, Boolean>,
    endScore: Int,
    onReplayClick: ()->Unit,
    onReturnToMenuClick: ()->Unit
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
        Spacer(modifier = Modifier.height(40.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            items(endWords.toList().chunked(2)) { // Convierte el mapa a una lista y luego divide en sublistas de 2 elementos
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    for ((key, value) in it) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(8.dp)
                        ) {
                            Text(
                                text = " ${key.name.replaceFirstChar { it.uppercase() }}",
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    fontFamily = pixeloidSansFamily
                                )
                            )
                            Text(
                                text = if (value) {"Correcto"} else {"Incorrecto"},
                                style = TextStyle(
                                    color = if (value) Color.Green else Color.Red,
                                    fontSize = 18.sp,
                                    fontFamily = pixeloidSansFamily
                                )
                            )
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(100.dp))
        GameButton(
            imageId = R.drawable.positive_button,
            text = stringResource(id = R.string.replay_esp),
            modifier = Modifier
                .width(190.dp)
                .height(50.dp)
        ) { onReplayClick() }
        GameButton(
            imageId = R.drawable.negative_button,
            text = stringResource(id = R.string.return_to_menu_esp),
            modifier = Modifier
                .width(190.dp)
                .height(50.dp)
        ) { onReturnToMenuClick() }
    }

}
