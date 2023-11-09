package com.example.pokedescifrarcompose.ui.screens.title

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedescifrarcompose.R
import com.example.pokedescifrarcompose.ui.screens.misc.PokeDialog
import com.example.pokedescifrarcompose.ui.screens.misc.PokeText

@Composable
fun TitleExitDialog(onConfirmClick: ()->Unit, onDismissClick: ()-> Unit, onDismiss: ()->Unit) {
    PokeDialog(
        confirmButton = {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                TitleButton(
                    imageId = R.drawable.negative_button,
                    text = stringResource(R.string.cancel_esp),
                    modifier = Modifier
                        .height(50.dp)
                        .width(190.dp)
                ) { onDismissClick() }
            }
        },
        dismissButton = {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                TitleButton(
                    imageId = R.drawable.positive_button,
                    text = stringResource(R.string.confirm_esp),
                    modifier = Modifier
                        .height(50.dp)
                        .width(190.dp)
                ) { onConfirmClick() }
            }
        },
        title = {
            PokeText(
                text = stringResource(R.string.dialog_alert_esp),
                fontSize = 24.sp,
                color = Color.Red,
                Color.LightGray,
                modifier = Modifier
            )
        },
        text = {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                PokeText(
                    text = stringResource(R.string.exit_game_esp),
                    fontSize = 18.sp,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    if (isSystemInDarkTheme()) Color.LightGray else Color.Black,
                    modifier = Modifier
                )
            }
        },
        icon = { TitleImage(modifier = Modifier.size(50.dp)) }
    ) {
        onDismiss()
    }
}
