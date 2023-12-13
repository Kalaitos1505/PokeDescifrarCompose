package com.example.pokedescifrarcompose.ui.screens.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pokedescifrarcompose.R
import com.example.pokedescifrarcompose.data.controller.SoundManager
import com.example.pokedescifrarcompose.data.controller.getTypeColor
import com.example.pokedescifrarcompose.data.viewmodel.BottomBarViewModel
import com.example.pokedescifrarcompose.data.viewmodel.GameViewModel
import com.example.pokedescifrarcompose.ui.screens.PokeDescifrarUI
import com.example.pokedescifrarcompose.ui.screens.end.GameEndScreen
import com.example.pokedescifrarcompose.ui.theme.PokePurple
import com.example.pokedescifrarcompose.ui.theme.PokeRed
import com.example.pokedescifrarcompose.ui.theme.pixeloidSansFamily

@Composable
fun GameScreen(
    navigation: NavController,
    bottomBarViewModel: BottomBarViewModel,
    gameViewModel: GameViewModel
) {
    val gameUIState by gameViewModel.uiState.collectAsState()
    var showEndDialog by remember { mutableStateOf(false) }
    var showHelpDialog by remember { mutableStateOf(false) }
    val backButton: ImageVector = ImageVector.vectorResource(id = R.drawable.ic_back)
    val helpButton: ImageVector = ImageVector.vectorResource(id = R.drawable.baseline_question_mark_24)



    if (gameUIState.areWordsLoaded) {
        bottomBarViewModel.setAboutEnabled(false) //Aquí desactivo el About
        PokeDescifrarUI(navigation = navigation, bottomBarViewModel = bottomBarViewModel) {
            if (!gameUIState.isGameOver) {
                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(320.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Start
                        ) {
                            IconButton(
                                onClick = { showEndDialog = showEndDialog.not() },
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
                        Row(
                            horizontalArrangement = Arrangement.End
                        ) {
                            IconButton(
                                onClick = { showHelpDialog = showHelpDialog.not() },
                                modifier = Modifier.size(35.dp),
                            ) {
                                Icon(
                                    helpButton,
                                    modifier = Modifier.size(25.dp),
                                    contentDescription = "",
                                    tint = PokeRed
                                )
                            }
                        }

                    }
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
                                .width(190.dp)
                                .height(50.dp)
                        ) { gameViewModel.checkUserGuess() }
                        GameButton(
                            imageId = R.drawable.negative_button,
                            text = stringResource(id = R.string.skip_esp),
                            modifier = Modifier
                                .width(190.dp)
                                .height(50.dp)
                        ) { gameViewModel.skipWord() }
                        Row(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
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
                    if (showEndDialog) {
                        GameExitDialog(
                            onConfirmClick = {
                                bottomBarViewModel.setAboutEnabled(true)
                                navigation.navigate("TitleScreen")
                            },
                            onDismissClick = {
                                SoundManager.playSFX(R.raw.button)
                                showEndDialog = false
                            }
                        ) { showEndDialog = false }
                    }
                    if (showHelpDialog) {
                        HelpDialog(onConfirmClick = {
                            showHelpDialog = false
                        }) {
                            showHelpDialog = false
                        }
                    }
                }
            } else {
                GameEndScreen(
                    endWords = gameUIState.correctWords,
                    endScore = gameUIState.score,
                    onReplayClick = { navigation.navigate("GameScreen") },
                    onReturnToMenuClick = { navigation.navigate("TitleScreen") }
                )
            }

        }
    } else {
        LoadingScreen()
    }
}




