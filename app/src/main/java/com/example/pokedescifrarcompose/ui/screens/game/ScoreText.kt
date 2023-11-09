package com.example.pokedescifrarcompose.ui.screens.game

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedescifrarcompose.R
import com.example.pokedescifrarcompose.ui.theme.pixeloidSansFamily

@Composable
fun ScoreText(
    score: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.score_esp, score),
            style = TextStyle(
                fontSize = 25.sp,
                fontFamily = pixeloidSansFamily
            ),
            modifier = Modifier.padding(8.dp)
        )
    }
}