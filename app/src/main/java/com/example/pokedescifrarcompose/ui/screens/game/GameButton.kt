package com.example.pokedescifrarcompose.ui.screens.game

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.pokedescifrarcompose.ui.screens.misc.PokeText

@Composable
fun GameButton(@DrawableRes imageId: Int, text: String, modifier: Modifier, onClick: ()-> Unit) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Image(
            painter = painterResource(imageId),
            modifier = Modifier.fillMaxSize(),
            contentDescription = "Title Screen Button",
        )
        PokeText(text = text, fontSize = 16.sp, color = Color.Black, Color.LightGray, modifier = Modifier)
    }
}