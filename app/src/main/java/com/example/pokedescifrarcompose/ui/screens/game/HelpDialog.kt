package com.example.pokedescifrarcompose.ui.screens.game

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.example.pokedescifrarcompose.R
import com.example.pokedescifrarcompose.ui.screens.misc.PokeText
import com.example.pokedescifrarcompose.ui.screens.title.TitleButton
import com.example.pokedescifrarcompose.ui.screens.title.TitleImage

@Composable
fun PokeHelpDialog(
    title: @Composable ()-> Unit,
    text: @Composable ()->Unit,
    icon: @Composable ()->Unit,
    confirmButton: @Composable ()->Unit,
    onDismissRequest: ()-> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        icon = icon,
        title = title,
        text = text,
        confirmButton = confirmButton,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = false
        ),
        )
}

@Composable
fun HelpDialog(onConfirmClick: ()-> Unit, onDismiss: ()->Unit) {
    PokeHelpDialog(
        confirmButton = {
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
                text = stringResource(R.string.help_dialog_title_esp),
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
                    text = stringResource(R.string.help_dialog_esp),
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