package com.example.pokedescifrarcompose.entities

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SoundViewModel : ViewModel() {
    private val _isMusicEnabled = mutableStateOf(true)
    private val _isSoundEnabled = mutableStateOf(true)

    val isMusicEnabled: State<Boolean> = _isMusicEnabled
    val isSoundEnabled: State<Boolean> = _isSoundEnabled

    fun setMusicEnabled(enabled: Boolean) {
        _isMusicEnabled.value = enabled
    }

    fun setSoundEnabled(enabled: Boolean) {
        _isSoundEnabled.value = enabled
    }
}