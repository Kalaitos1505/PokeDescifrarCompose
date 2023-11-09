package com.example.pokedescifrarcompose.ui.screens.appbars

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.pokedescifrarcompose.R
import com.example.pokedescifrarcompose.ui.screens.misc.PokeText
import com.example.pokedescifrarcompose.ui.theme.PokeRed


@Composable
fun BottomToggleAppBarButton(
    selectedIcon: ImageVector,
    notSelectedIcon: ImageVector,
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    onClick: ()-> Unit,

    ) {
    IconButton(
        onClick = {
            onClick()
        },
        modifier = modifier
            .size(35.dp)
    ) {
        Icon(
            if (isSelected) selectedIcon else notSelectedIcon,
            modifier = Modifier
                .size(35.dp),
            contentDescription = "Bottom Bar Buttons",
            tint = PokeRed
        )
    }
}

@Composable
fun BottomAppBarButton(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: ()-> Unit
) {
    IconButton(
        onClick = { onClick() },
        modifier = Modifier.size(35.dp)
    ) {
        Icon(
            icon,
            modifier = Modifier.size(25.dp),
            contentDescription = "",
            tint = PokeRed
        )
    }
}


@Composable
fun AboutAppBarButton(
    @DrawableRes imageId: Int,
    text: String,
    onClick: () -> Unit
) {
    var isSelected by remember { mutableStateOf(true) }

    Button(
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = PokeRed
        ),
        onClick = {
            isSelected = !isSelected
            onClick()
        },
        modifier = Modifier.fillMaxHeight()
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = imageId),
                modifier = Modifier.size(35.dp),
                contentDescription = ""
            )

            PokeText(
                text = text,
                fontSize = 16.sp,
                color = Color.Black,
                shadowColor = Color.LightGray,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}

@Composable
@Preview
fun BottomAppBarButtonPreview() {
    BottomAppBarButton(
        Icons.Filled.Info
    ) {
    }
}

@Composable
@Preview
fun AboutAppBarButtonPreview() {
    AboutAppBarButton(R.drawable.pokedex, text = "Notas de parche") { }
}