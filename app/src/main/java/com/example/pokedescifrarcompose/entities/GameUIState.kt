package com.example.pokedescifrarcompose.entities

data class GameUIState(
    val currentScrambledWord: String = "",
    val userGuess: String = "",
    val currentPokemonTypes: List<String> = emptyList(),
    val currentWordCount: Int = 1,
    val score: Int = 0,
    val isGuessedWordWrong: Boolean = false,
    val isGameOver: Boolean = false,
    val areWordsLoaded: Boolean = false,
    val correctWords: Map<Pokemon, Boolean> = emptyMap()
)
