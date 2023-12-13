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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pokedescifrarcompose.data.controller.SoundManager
import com.example.pokedescifrarcompose.data.viewmodel.BottomBarViewModel
import com.example.pokedescifrarcompose.ui.screens.appbars.BottomBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokeDescifrarUI(
    navigation: NavController,
    bottomBarViewModel: BottomBarViewModel,
    content: @Composable ()-> Unit
) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = {
                BottomBar(
                    isMusicEnabled = bottomBarViewModel.isMusicEnabled.value,
                    isSoundEnabled = bottomBarViewModel.isSoundEnabled.value,
                    isAboutEnabled = bottomBarViewModel.isAboutEnabled.value,
                    onMusicToggleCLick = { isEnabled ->
                        bottomBarViewModel.setMusicEnabled(isEnabled)
                        if (isEnabled) {
                            SoundManager.toggleMusic(true)
                            SoundManager.playMusic(SoundManager.getCurrentPlayingSongResId())
                        } else {
                            SoundManager.toggleMusic(false)
                            SoundManager.stopMusic()
                        }
                    },
                    onSoundToggleClick = { isEnabled ->
                        bottomBarViewModel.setSoundEnabled(isEnabled)
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