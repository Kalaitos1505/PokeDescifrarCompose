package com.example.pokedescifrarcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedescifrarcompose.data.controller.SoundManager
import com.example.pokedescifrarcompose.data.viewmodel.GameViewModel
import com.example.pokedescifrarcompose.data.viewmodel.SoundViewModel
import com.example.pokedescifrarcompose.data.repositories.PokemonRepository
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
                    composable("TitleScreen") {
                        BackHandler(true) {}
                        TitleScreen(navigation = navController, soundViewModel) 
                    }
                    composable("AboutScreen") {
                        BackHandler(true) {}
                        AboutScreen(navigation = navController)
                    }
                    composable("SettingsScreen") {
                        BackHandler(true) {}
                        SettingsScreen(navigation = navController, soundViewModel)
                    }
                    composable("GameScreen") {
                        BackHandler(false) {}
                        GameScreen(navigation = navController, soundViewModel = soundViewModel, gameViewModel = GameViewModel(PokemonRepository()))
                    }
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




