package com.example.pokedescifrarcompose.ui.screens.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.pokedescifrarcompose.R
import com.example.pokedescifrarcompose.ui.screens.appbars.AboutBottomBar
import com.example.pokedescifrarcompose.ui.theme.PokeRed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutUI(onPatchNotesButtonClick: ()->Unit, onCreditsButtonCLick: ()->Unit, onBackButtonClick: ()->Unit,content: @Composable ()-> Unit) {
    val backButton: ImageVector = ImageVector.vectorResource(id = R.drawable.ic_back)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = { AboutBottomBar(onPatchNotesClick = { onPatchNotesButtonClick() }, onCreditsClick = { onCreditsButtonCLick() }) }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(horizontalArrangement = Arrangement.Start) {
                    IconButton(
                        onClick = { onBackButtonClick() },
                        modifier = Modifier.size(35.dp),
                    ) {
                        Icon(
                            backButton,
                            modifier = Modifier.size(25.dp),
                            contentDescription = "",
                            tint = PokeRed
                        )
                    }
                }
                content()
            }
        }



    }
}