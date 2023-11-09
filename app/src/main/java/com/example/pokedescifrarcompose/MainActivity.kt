package com.example.pokedescifrarcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.viewbinding.BuildConfig
import com.example.pokedescifrarcompose.controller.SoundManager
import com.example.pokedescifrarcompose.entities.GameViewModel
import com.example.pokedescifrarcompose.entities.SoundViewModel
import com.example.pokedescifrarcompose.repositories.PokemonRepository
import com.example.pokedescifrarcompose.ui.screens.about.AboutScreen
import com.example.pokedescifrarcompose.ui.screens.game.GameScreen
import com.example.pokedescifrarcompose.ui.screens.settings.SettingsScreen
import com.example.pokedescifrarcompose.ui.screens.title.TitleScreen
import com.example.pokedescifrarcompose.ui.theme.PokeDescifrarComposeTheme

class MainActivity : ComponentActivity() {

    private val soundViewModel: SoundViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Music and SFX initializer
        SoundManager.initialize(this)

        // App content
        setContent {
            PokeDescifrarComposeTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController, startDestination = "TitleScreen",
                    enterTransition = { EnterTransition.None},
                    exitTransition = { ExitTransition.None },
                ) {
                    composable("TitleScreen") { TitleScreen(navigation = navController, soundViewModel) }
                    composable("AboutScreen") { AboutScreen(navigation = navController)}
                    composable("SettingsScreen") { SettingsScreen(navigation = navController, soundViewModel)}
                    composable("GameScreen") { GameScreen(navigation = navController, soundViewModel = soundViewModel, gameViewModel = GameViewModel(PokemonRepository()))}
                    composable("EndScreen") { }
                }
            }
        }
    }

    override fun onDestroy() {
        SoundManager.stopMusic()
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        SoundManager.resumeMusic()
    }

    override fun onPause() {
        super.onPause()
        SoundManager.pauseMusic()
    }
}




