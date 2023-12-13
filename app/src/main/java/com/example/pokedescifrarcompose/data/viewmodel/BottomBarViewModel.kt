package com.example.pokedescifrarcompose.data.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class BottomBarViewModel : ViewModel() {
    private val _isMusicEnabled = mutableStateOf(true)
    private val _isSoundEnabled = mutableStateOf(true)
    private val _isAboutEnabled = mutableStateOf(true)

    val isMusicEnabled: State<Boolean> = _isMusicEnabled
    val isSoundEnabled: State<Boolean> = _isSoundEnabled
    val isAboutEnabled: State<Boolean> = _isAboutEnabled

    fun setMusicEnabled(enabled: Boolean) {
        _isMusicEnabled.value = enabled
    }

    fun setSoundEnabled(enabled: Boolean) {
        _isSoundEnabled.value = enabled
    }

    fun setAboutEnabled(enabled: Boolean) {
        _isAboutEnabled.value = enabled
    }
}