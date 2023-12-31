package com.example.pokedescifrarcompose.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedescifrarcompose.data.controller.translateType
import com.example.pokedescifrarcompose.data.entities.GameUIState
import com.example.pokedescifrarcompose.data.entities.MAX_NO_OF_WORDS
import com.example.pokedescifrarcompose.data.entities.Pokemon
import com.example.pokedescifrarcompose.data.entities.SCORE_INCREASE
import com.example.pokedescifrarcompose.data.repositories.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(GameUIState())
    val uiState: StateFlow<GameUIState> = _uiState.asStateFlow()

    private var usedWords: MutableSet<String> = mutableSetOf()
    private lateinit var currentWord: String

    private var pokemonList: List<Pokemon> = emptyList()
    private var pokemonShuffledList: List<Pokemon> = emptyList()
    private var correctWords = mutableMapOf<Pokemon, Boolean>()
    private var currentPokemonIndex = 0

    private val isPokemonListLoaded = MutableLiveData<Boolean>()



    init {
        startGame()
    }

    private fun resetGame() {
        usedWords.clear()
        currentPokemonIndex = 0
        pokemonList = emptyList()
        _uiState.value = GameUIState()
    }

    private fun startGame() {
        resetGame()
        isPokemonListLoaded.observeForever(object : Observer<Boolean> {
            override fun onChanged(value: Boolean) {
                isPokemonListLoaded.removeObserver(this)
                if (value && pokemonList.isNotEmpty()) {
                    getNextWord()
                }
            }
        })
        loadPokemonList()
    }

    fun updateUserGuess(guessedWord: String){
        _uiState.value = _uiState.value.copy(userGuess = guessedWord)
    }

    fun checkUserGuess() {
        if (uiState.value.currentWordCount <= MAX_NO_OF_WORDS) {
            if (uiState.value.userGuess.equals(pokemonList[currentPokemonIndex].name, ignoreCase = true)) {
                val updatedScore = _uiState.value.score.plus(SCORE_INCREASE)
                updateGameState(updatedScore)
                correctWords.put(pokemonList[currentPokemonIndex], true)
                if (correctWords.size == MAX_NO_OF_WORDS) {
                    gameOver()
                } else {
                    currentPokemonIndex++
                    getNextWord()
                }

            } else {
                _uiState.update { currentState ->
                    currentState.copy(isGuessedWordWrong = true)
                }
            }
        }
    }

    fun skipWord() {
        correctWords.put(pokemonList[currentPokemonIndex], false)
        if (uiState.value.currentWordCount == MAX_NO_OF_WORDS) {
             gameOver()
        } else {
            updateGameState(uiState.value.score)
            currentPokemonIndex++
            getNextWord()
        }

    }

    private fun updateGameState(updatedScore: Int) {
            _uiState.update { currentState ->
                currentState.copy(
                    userGuess = "",
                    isGuessedWordWrong = false,
                    currentWordCount = currentState.currentWordCount.inc(),
                    score = updatedScore
                )
            }
    }

    private fun gameOver() {
        _uiState.update { currentState ->
            currentState.copy(
                isGuessedWordWrong = false,
                correctWords = correctWords,
                isGameOver = true
            )
        }
    }

    private fun shuffleList(pokemons: List<Pokemon>): List<Pokemon> {
        return pokemons.map { pokemon ->
            val name = pokemon.name
            val shuffledName = name.replaceFirstChar { it.uppercase() }.toCharArray().apply {
                shuffle()
            }.joinToString(separator = "")
            Pokemon(name = shuffledName, types = pokemon.types)
        }
    }

    private fun getNextWord() {
        val currentPokemon = pokemonShuffledList[currentPokemonIndex]
        currentWord = currentPokemon.name

        val types = currentPokemon.types.map { translateType(it.type.name) }

        _uiState.value = _uiState.value.copy(
            currentScrambledWord = currentWord,
            areWordsLoaded = true,
            currentPokemonTypes = types
        )
    }

    private fun loadPokemonList() {
        viewModelScope.launch {
            val apiPokemonList = pokemonRepository.getRandomPokemonList()
            if (apiPokemonList != null) {
                pokemonList = apiPokemonList
                pokemonShuffledList = shuffleList(apiPokemonList)
                isPokemonListLoaded.postValue(true)
            } else {
                isPokemonListLoaded.postValue(false)
            }
        }
    }
    }
