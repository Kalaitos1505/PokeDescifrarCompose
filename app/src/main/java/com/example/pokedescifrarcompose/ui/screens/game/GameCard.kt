package com.example.pokedescifrarcompose.ui.screens.game

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedescifrarcompose.R
import com.example.pokedescifrarcompose.ui.theme.PokePurple
import com.example.pokedescifrarcompose.ui.theme.PokeRed
import com.example.pokedescifrarcompose.ui.theme.pixeloidSansFamily

@Composable
fun GameCard(
    currentScrambledWord: String,
    wordCount: Int,
    isGuessWrong: Boolean,
    userGuess: String,
    onUserGuessChanged: (String) -> Unit,
    onKeyboardDone: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        border = BorderStroke(2.dp, PokePurple),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(
            //containerColor = PokePurple
        )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                modifier = Modifier
                    .clip(shapes.medium)
                    .background(PokeRed)
                    .padding(horizontal = 10.dp, vertical = 4.dp)
                    .align(alignment = Alignment.End),
                text = stringResource(R.string.word_count, wordCount),
                fontFamily = pixeloidSansFamily,
                color = Color.White
            )
            Text(
                text = currentScrambledWord,
                style = TextStyle(
                    fontSize = 40.sp,
                    fontFamily =  pixeloidSansFamily
                )
            )
            Text(
                text = stringResource(R.string.game_description_esp),
                textAlign = TextAlign.Center,
                fontFamily = pixeloidSansFamily
            )
            PokeTextField(
                userGuess = userGuess,
                onUserGuessChanged = onUserGuessChanged,
                isGuessWrong = isGuessWrong,
                modifier = Modifier.padding(bottom = 15.dp),
                onKeyBoardDone = { onKeyboardDone() }
            )
        }

    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun CardPreview() {
    GameCard(
        currentScrambledWord = "noUmrbe",
        wordCount = 3,
        isGuessWrong = false,
        userGuess = "Umbreon",
        onUserGuessChanged = {},
        onKeyboardDone = { /*TODO*/ })
}