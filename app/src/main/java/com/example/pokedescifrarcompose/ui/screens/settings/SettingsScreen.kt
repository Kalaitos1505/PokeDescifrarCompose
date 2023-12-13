package com.example.pokedescifrarcompose.ui.screens.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pokedescifrarcompose.R
import com.example.pokedescifrarcompose.data.controller.SoundManager
import com.example.pokedescifrarcompose.data.viewmodel.BottomBarViewModel
import com.example.pokedescifrarcompose.ui.screens.PokeDescifrarUI
import com.example.pokedescifrarcompose.ui.screens.appbars.BottomAppBarButton


@Composable
fun SettingsScreen(navigation: NavController, bottomBarViewModel: BottomBarViewModel) {

    val backButton: ImageVector = ImageVector.vectorResource(id = R.drawable.ic_back)

    PokeDescifrarUI(
        navigation = navigation,
        bottomBarViewModel = bottomBarViewModel
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            BottomAppBarButton(
                backButton,
                modifier = Modifier.padding(5.dp)
            ) { navigation.popBackStack() }
        }
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            SettingsCheckbox(
                text = stringResource(R.string.music_esp),
                modifier = Modifier,
                isChecked = bottomBarViewModel.isMusicEnabled.value,
                onCheckedChange = { isEnabled ->
                    bottomBarViewModel.setMusicEnabled(isEnabled)
                    if (isEnabled) {
                        SoundManager.toggleMusic(true)
                        SoundManager.playMusic(SoundManager.getCurrentPlayingSongResId())
                    } else {
                        SoundManager.toggleMusic(false)
                        SoundManager.stopMusic()
                    }
                }
            )
            Divider(
                color = Color.Black,
                modifier = Modifier.width(3.dp)
                    .padding(3.dp)
            )

            SettingsCheckbox(
                text = stringResource(R.string.sfx_esp),
                modifier = Modifier,
                isChecked = bottomBarViewModel.isSoundEnabled.value,
                onCheckedChange = { isEnabled ->
                    bottomBarViewModel.setSoundEnabled(isEnabled)
                    if (isEnabled) {
                        SoundManager.toggleSFX(true)
                    } else {
                        SoundManager.toggleSFX(false)
                    }
                }
            )
        }
    }
}

@Composable
@Preview
fun SettingsScreenPreview() {
    SettingsScreen(navigation = rememberNavController(), bottomBarViewModel = BottomBarViewModel())
}
