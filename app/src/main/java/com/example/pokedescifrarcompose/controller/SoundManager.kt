package com.example.pokedescifrarcompose.controller

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.SoundPool
import android.util.Log
import androidx.annotation.RawRes
import com.example.pokedescifrarcompose.R

private lateinit var appContext: Context

object SoundManager {
    private var mediaPlayer: MediaPlayer? = null
    private var soundPool: SoundPool? = null
    private val soundMap = mutableMapOf<Int, Int>()
    private var currentPlayingSongResId: Int = 0
    private var isSoundEnabled: Boolean = true
    private var isMusicEnabled: Boolean = true

    //If adding a playlist is needed
    //private  val songList = mutableListOf<Int>()
    //private var currentSongIndex = 0

    fun initialize(context: Context) {
        appContext = context
        //App starting music initialization
        playMusic(R.raw.littleroot)

        //SFXs config
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        soundPool = SoundPool.Builder()
            .setMaxStreams(16)
            .setAudioAttributes(audioAttributes)
            .build()

        loadSFX(R.raw.button)
        loadSFX(R.raw.changeopt)
        loadSFX(R.raw.correct)
        loadSFX(R.raw.runaway)
        loadSFX(R.raw.skip)
        loadSFX(R.raw.switchopt)
    }

    fun playMusic(@RawRes songResId: Int) {
        stopMusic()
        mediaPlayer = MediaPlayer.create(appContext, songResId)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start()
        currentPlayingSongResId = songResId
    }

    fun getCurrentPlayingSongResId(): Int {
        return currentPlayingSongResId
    }

    fun stopMusic() {
        mediaPlayer?.stop()
        mediaPlayer?.reset()
    }

    fun pauseMusic() {
        mediaPlayer?.pause()
    }

    fun resumeMusic() {
        mediaPlayer?.start()
    }

    private fun loadSFX(@RawRes soundResId: Int) {
        val soundId = soundPool?.load(appContext, soundResId, 1) ?: 0
        soundMap[soundResId] = soundId
    }

    fun playSFX(@RawRes soundResId: Int) {
        if (isSoundEnabled) {
            val soundId = soundMap[soundResId]
            soundId?.let {
                soundPool?.play(it, 1.0f, 1.0f, 1, 0, 1.0f)
            }
        }
    }


    fun toggleMusic(enabled: Boolean) {
        isMusicEnabled = enabled
    }

    fun isMusicEnabled(): Boolean {
        return isMusicEnabled
    }

    fun toggleSFX(enabled: Boolean) {
        isSoundEnabled = enabled
    }

    fun isSFXEnabled(): Boolean {
        return isSoundEnabled
    }
}

