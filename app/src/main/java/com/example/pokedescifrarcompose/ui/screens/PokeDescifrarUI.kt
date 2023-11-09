package com.example.pokedescifrarcompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pokedescifrarcompose.ui.screens.appbars.BottomBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.pokedescifrarcompose.controller.SoundManager
import com.example.pokedescifrarcompose.entities.SoundViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokeDescifrarUI(
    navigation: NavController,
    soundViewModel: SoundViewModel,
    content: @Composable ()-> Unit
) {
    var isMusicEnabled by remember { mutableStateOf(true) }
    var isSoundEnabled by remember { mutableStateOf(true) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = {
                BottomBar(
                    isMusicEnabled = soundViewModel.isMusicEnabled.value,
                    isSoundEnabled = soundViewModel.isSoundEnabled.value,
                    onMusicToggleCLick = { isEnabled ->
                        soundViewModel.setMusicEnabled(isEnabled)
                        if (isEnabled) {
                            SoundManager.toggleMusic(true)
                            SoundManager.playMusic(SoundManager.getCurrentPlayingSongResId())
                        } else {
                            SoundManager.toggleMusic(false)
                            SoundManager.stopMusic()
                        }
                    },
                    onSoundToggleClick = { isEnabled ->
                        soundViewModel.setSoundEnabled(isEnabled)
                        if (isEnabled) {
                            SoundManager.toggleSFX(true)
                        } else {
                            SoundManager.toggleSFX(false)
                        }
                    },
                    navigation
                )

                        },
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                content()
            }
        }
    }
}