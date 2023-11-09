package com.example.pokedescifrarcompose.ui.screens.appbars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pokedescifrarcompose.R
import com.example.pokedescifrarcompose.ui.theme.PokeRed

@Composable
fun AboutBottomBar(onPatchNotesClick: () -> Unit, onCreditsClick: () -> Unit) {
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AboutAppBarButton(imageId = R.drawable.pokedex, text = stringResource(R.string.credits_esp)) { onCreditsClick() }
            Divider(color = Color.Black, modifier = Modifier.fillMaxHeight().width(1.dp))
            AboutAppBarButton(imageId = R.drawable.patchnotes, text = stringResource(R.string.patch_notes_esp)) { onPatchNotesClick() }
        }
    }
}