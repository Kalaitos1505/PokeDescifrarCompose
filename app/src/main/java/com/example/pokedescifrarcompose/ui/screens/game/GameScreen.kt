package com.example.pokedescifrarcompose.ui.screens.game

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pokedescifrarcompose.R
import com.example.pokedescifrarcompose.controller.getTypeColor
import com.example.pokedescifrarcompose.entities.GameViewModel
import com.example.pokedescifrarcompose.entities.SoundViewModel
import com.example.pokedescifrarcompose.repositories.PokemonRepository
import com.example.pokedescifrarcompose.ui.screens.PokeDescifrarUI
import com.example.pokedescifrarcompose.ui.screens.appbars.BottomAppBarButton
import com.example.pokedescifrarcompose.ui.screens.end.GameEndScreen
import com.example.pokedescifrarcompose.ui.screens.misc.PokeText
import com.example.pokedescifrarcompose.ui.screens.title.TitleButton
import com.example.pokedescifrarcompose.ui.theme.PokePurple
import com.example.pokedescifrarcompose.ui.theme.pixeloidSansFamily

@Composable
fun GameScreen(
    navigation: NavController,
    soundViewModel: SoundViewModel,
    gameViewModel: GameViewModel
) {
    val gameUIState by gameViewModel.uiState.collectAsState()
    if (gameUIState.areWordsLoaded) {
        PokeDescifrarUI(navigation = navigation, soundViewModel = soundViewModel) {
            if (!gameUIState.isGameOver) {

                val backButton: ImageVector = ImageVector.vectorResource(id = R.drawable.ic_back)

                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.Center,
                ) {
                    BottomAppBarButton(
                        backButton,
                        modifier = Modifier
                            .align(Alignment.Start)

                    ) { navigation.popBackStack() }
                    GameCard(
                        currentScrambledWord = gameUIState.currentScrambledWord,
                        wordCount = gameUIState.currentWordCount,
                        isGuessWrong = gameUIState.isGuessedWordWrong,
                        userGuess = gameUIState.userGuess,
                        onUserGuessChanged = { gameViewModel.updateUserGuess(it) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(20.dp),
                        onKeyboardDone = { /*TODO*/ }
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        GameButton(
                            imageId = R.drawable.positive_button,
                            text = stringResource(id = R.string.confirm_esp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {gameViewModel.checkUserGuess()}
                        GameButton(
                            imageId = R.drawable.negative_button,
                            text = stringResource(id = R.string.skip_esp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {gameViewModel.skipWord()}
                        Row(
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                                Text(
                                    text = gameUIState.currentPokemonTypes[0],
                                    fontSize = 15.sp,
                                    color = getTypeColor(gameUIState.currentPokemonTypes[0]),
                                    fontFamily = pixeloidSansFamily
                                )

                            if (gameUIState.currentPokemonTypes.size >= 2) {
                                Text(
                                    text = "/",
                                    fontSize = 15.sp,
                                    color = PokePurple,
                                    fontFamily = pixeloidSansFamily
                                )
                                Text(
                                    text = gameUIState.currentPokemonTypes[1],
                                    fontSize = 15.sp,
                                    color = getTypeColor(gameUIState.currentPokemonTypes[1]),
                                    fontFamily = pixeloidSansFamily
                                )
                            }
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        ScoreText(score = gameUIState.score, modifier = Modifier)
                    }
                }
            }  else  {
                GameEndScreen(endWords = gameUIState.correctWords, endScore = gameUIState.score)
            }

        }
    } else {
        LoadingScreen()
    }
}



