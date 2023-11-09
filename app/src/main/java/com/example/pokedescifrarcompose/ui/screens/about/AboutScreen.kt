package com.example.pokedescifrarcompose.ui.screens.about

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.pokedescifrarcompose.ui.screens.PokeDescifrarUI
import com.example.pokedescifrarcompose.entities.patchNoteList
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.pokedescifrarcompose.entities.creditsList

@Composable
fun AboutScreen(navigation: NavController) {
    var showPatchNotes by remember { mutableStateOf(true) }
    var showCredits by remember { mutableStateOf(false) }

    AboutUI(
        onPatchNotesButtonClick = {
            showPatchNotes = true
            showCredits = false
        },
        onCreditsButtonCLick = {
            showPatchNotes = false
            showCredits = true
        }
    ) {

        if (showPatchNotes) {
            PatchNotesContent()
        } else if (showCredits) {
            CreditsContent()
        }

        /*Código de los créditos*/
    }
}

@Composable
fun PatchNotesContent() {
    PatchNotesSpinner(patchNotes = patchNoteList)
}

@Composable
fun CreditsContent() {
    CreditsText(credits = creditsList)
}