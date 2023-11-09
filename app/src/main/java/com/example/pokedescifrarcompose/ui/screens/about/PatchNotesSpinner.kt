package com.example.pokedescifrarcompose.ui.screens.about

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedescifrarcompose.data.entities.PatchNote
import com.example.pokedescifrarcompose.data.entities.patchNoteList
import com.example.pokedescifrarcompose.ui.screens.misc.PokeText
import com.example.pokedescifrarcompose.ui.theme.PokeRed

var selectedPatchNote: PatchNote? = null

@Composable
fun PatchNotesSpinner(patchNotes: List<PatchNote>) {
    var versionText by remember { mutableStateOf("Selecciona una versión...") }
    var expanded by remember { mutableStateOf(false)}
    Column {
        Box(
            Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                Modifier
                    .padding(8.dp)
                    .clickable { expanded = !expanded },
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                PokeText(text = versionText,
                    fontSize = 18.sp,
                    color = if(isSystemInDarkTheme()) Color.White else Color.Black,
                    shadowColor = if(isSystemInDarkTheme()) PokeRed else Color.White,
                    modifier = Modifier
                )
                Icon(imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = "",
                    tint = PokeRed
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {expanded = false},
                ) {
                    patchNotes.forEach {
                            patchNote -> DropdownMenuItem(
                        onClick = {
                            expanded = false
                            versionText = patchNote.toString()
                            selectedPatchNote = patchNote
                        },
                        text = {
                            Text(
                                text = patchNote.version
                            )
                        }
                    )
                    }
                }
            }
        }
        Divider(
            modifier = Modifier.padding(6.dp),
            thickness = 1.dp,
            color = PokeRed,
        )
        PatchNoteDetail(selectedPatchNote = selectedPatchNote)
    }

}

@Composable
fun PatchNoteDetail(selectedPatchNote: PatchNote?) {
    Column(Modifier.padding(top = 10.dp)) {
        selectedPatchNote?.changes?.forEach() { change ->
            PokeText(
                text = "- $change",
                fontSize = 15.sp,
                color = if(isSystemInDarkTheme()) Color.White else Color.Black,
                shadowColor = if(isSystemInDarkTheme()) PokeRed else Color.White,
                modifier = Modifier.padding(6.dp))
        }
    }
}

@Composable
@Preview
fun SpinnerPreview() {
        Column() {
            PatchNotesSpinner(patchNotes = patchNoteList)
        }
}



