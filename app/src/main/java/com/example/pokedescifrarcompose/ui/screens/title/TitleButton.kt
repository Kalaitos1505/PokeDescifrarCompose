package com.example.pokedescifrarcompose.ui.screens.title

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedescifrarcompose.R
import com.example.pokedescifrarcompose.ui.screens.misc.PokeText
import com.example.pokedescifrarcompose.ui.theme.pixeloidSansFamily

@Composable
fun TitleButton(@DrawableRes imageId: Int, text: String, modifier: Modifier, onClick: ()-> Unit) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Image(
            painter = painterResource(imageId),
            modifier = Modifier.size(200.dp),
            contentDescription = "Title Screen Button",
        )
        PokeText(text = text, fontSize = 16.sp, color = Color.Black, Color.LightGray, modifier = Modifier)
    }
}

@Composable
@Preview
fun TitleButtonPreview1() {
    TitleButton(imageId = R.drawable.positive_button, "Iniciar Partida", modifier = Modifier
        .padding(top = 30.dp)
        .height(50.dp)
        .width(190.dp)) {
        //onClick()
    }
}
