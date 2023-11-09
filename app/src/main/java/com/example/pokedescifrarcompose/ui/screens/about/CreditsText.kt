package com.example.pokedescifrarcompose.ui.screens.about

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedescifrarcompose.data.entities.Credits
import com.example.pokedescifrarcompose.data.entities.creditsList
import com.example.pokedescifrarcompose.ui.screens.misc.PokeText
import com.example.pokedescifrarcompose.ui.theme.PokeRed

@Composable
fun CreditsText(credits: List<Credits>) {

        Column(modifier = Modifier.padding(start = 10.dp, top = 5.dp))  {
            credits.forEach() { credit ->
                PokeText(
                    text = credit.description,
                    fontSize = 25.sp,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    shadowColor = if (isSystemInDarkTheme()) PokeRed else Color.White,
                    modifier = Modifier.padding(bottom = 5.dp, top = 10.dp)
                )
                PokeText(
                    text = credit.credit,
                    fontSize = 15.sp,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    shadowColor = if (isSystemInDarkTheme()) PokeRed else Color.White,
                    modifier = Modifier.padding(bottom = 15.dp)
                )
                Divider(thickness = 2.dp, color = PokeRed)
            }
        }

}

@Composable
@Preview
fun CreditsTextPreview() {
    CreditsText(creditsList)
}


