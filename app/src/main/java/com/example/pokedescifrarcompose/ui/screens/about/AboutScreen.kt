package com.example.pokedescifrarcompose.ui.screens.about

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.pokedescifrarcompose.data.entities.creditsList
import com.example.pokedescifrarcompose.data.entities.patchNoteList

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