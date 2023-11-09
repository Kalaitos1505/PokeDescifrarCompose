package com.example.pokedescifrarcompose.ui.screens.misc


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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.example.pokedescifrarcompose.R
import com.example.pokedescifrarcompose.ui.screens.title.TitleButton
import com.example.pokedescifrarcompose.ui.screens.title.TitleImage

@Composable
fun PokeDialog(
    title: @Composable ()-> Unit,
    text: @Composable ()->Unit,
    icon: @Composable ()->Unit,
    confirmButton: @Composable ()->Unit,
    dismissButton: @Composable ()->Unit,
    onDismissRequest: ()-> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        icon = icon,
        title = title,
        text = text,
        dismissButton = dismissButton,
        confirmButton = confirmButton,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = false
        ),

    )
}

@Composable
@Preview
fun PokeDialogPreview() {
    PokeDialog(
        confirmButton = {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                TitleButton(imageId = R.drawable.positive_button, text = stringResource(R.string.confirm_esp), modifier = Modifier
                    .height(50.dp)
                    .width(190.dp))
                { /*TODO*/}
            }
        },
        dismissButton = { TitleButton(imageId = R.drawable.negative_button, text = stringResource(R.string.cancel_esp), modifier = Modifier
            .height(50.dp)
            .width(190.dp))
        { /*TODO*/ }},
        title = {
                PokeText(text = "Prueba", fontSize = 24.sp , color = Color.Red, if(isSystemInDarkTheme()) Color.LightGray else Color.Black, modifier = Modifier)
        },
        text = {
            PokeText(text = "Este es un dialog totalmente de prueba, es decir, si quieres dale a cerrar, o no...", fontSize = 24.sp , color = Color.Black, if(isSystemInDarkTheme()) Color.LightGray else Color.Black, modifier = Modifier)
        },
        icon = { TitleImage(modifier = Modifier.size(300.dp)) }
    ) {
        /*TODO*/
    }
}