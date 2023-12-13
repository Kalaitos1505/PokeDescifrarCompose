package com.example.pokedescifrarcompose.ui.screens.title

import android.app.Activity
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pokedescifrarcompose.R
import com.example.pokedescifrarcompose.data.controller.SoundManager
import com.example.pokedescifrarcompose.data.viewmodel.BottomBarViewModel
import com.example.pokedescifrarcompose.ui.screens.PokeDescifrarUI
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.exitProcess


@Composable
fun TitleScreen(navigation: NavController, bottomBarViewModel: BottomBarViewModel) {
    bottomBarViewModel.setAboutEnabled(true)
    val activity = (LocalContext.current as? Activity)
    var showDialog by remember { mutableStateOf(false) }
    PokeDescifrarUI(
        navigation = navigation,
        bottomBarViewModel = bottomBarViewModel
    ) {
        TitleText()
        TitleImage(modifier = Modifier.size(200.dp))
        TitleButton(
            imageId = R.drawable.positive_button,
            text = stringResource(R.string.start_game_esp),
            modifier = Modifier
                .padding(top = 30.dp)
                .height(50.dp)
                .width(190.dp)
        ) {
            SoundManager.playSFX(R.raw.button)
            navigation.navigate("GameScreen")
        }
        TitleButton(
            imageId = R.drawable.positive_button,
            text = stringResource(R.string.settings_esp),
            modifier = Modifier
                .padding(top = 30.dp)
                .height(50.dp)
                .width(190.dp)
        ) {
            SoundManager.playSFX(R.raw.switchopt)
            navigation.navigate("SettingsScreen")
        }
        TitleButton(
            imageId = R.drawable.negative_button,
            text = stringResource(R.string.exit_esp),
            modifier = Modifier
                .padding(top = 30.dp)
                .height(50.dp)
                .width(190.dp)
        ) {
            R.raw.button
            showDialog = showDialog.not()
        }
        if (showDialog) {
            TitleExitDialog(
                onConfirmClick = {

                    SoundManager.playSFX(R.raw.runaway)
                    runBlocking {
                        delay(1500)
                    }
                    activity?.finish()
                    exitProcess(0)
                },
                onDismissClick = {
                    SoundManager.playSFX(R.raw.button)
                    showDialog = false
                }
            ) { showDialog = false }
        }

    }
}