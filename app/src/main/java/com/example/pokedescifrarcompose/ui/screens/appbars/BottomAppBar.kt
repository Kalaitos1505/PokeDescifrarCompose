package com.example.pokedescifrarcompose.ui.screens.appbars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pokedescifrarcompose.R


@Composable
fun BottomBar(
    isMusicEnabled: Boolean,
    isSoundEnabled: Boolean,
    onMusicToggleCLick: (Boolean) -> Unit,
    onSoundToggleClick: (Boolean) -> Unit,
    navigation: NavController
) {

    val volumeOn: ImageVector = ImageVector.vectorResource(id = R.drawable.baseline_volume_up_24)
    val volumeOff: ImageVector = ImageVector.vectorResource(id = R.drawable.baseline_volume_off_24)
    val musicOn: ImageVector = ImageVector.vectorResource(id = R.drawable.baseline_music_note_24)
    val musicOff: ImageVector = ImageVector.vectorResource(id = R.drawable.baseline_music_off_24)

    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                BottomToggleAppBarButton(
                    musicOn,
                    musicOff,
                    isSelected = isMusicEnabled
                ) { onMusicToggleCLick(!isMusicEnabled) }
                BottomToggleAppBarButton(
                    volumeOn,
                    volumeOff,
                    isSelected = isSoundEnabled
                ) { onSoundToggleClick(!isSoundEnabled) }
            }
            Row(horizontalArrangement = Arrangement.End) {
                BottomAppBarButton(
                    Icons.Filled.Info
                ) { navigation.navigate("AboutScreen") }
            }
        }
    }
}