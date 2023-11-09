package com.example.pokedescifrarcompose.ui.screens.settings



import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedescifrarcompose.ui.screens.misc.PokeText
import com.example.pokedescifrarcompose.ui.theme.PokePurple
import com.example.pokedescifrarcompose.ui.theme.PokeRed
import com.example.pokedescifrarcompose.ui.theme.pixeloidSansFamily

@Composable
fun SettingsCheckbox(
    text: String,
    modifier: Modifier,
    isChecked: Boolean,
    onCheckedChange: (Boolean)->Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(PokePurple),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PokeText(text = text, fontSize = 16.sp, color = Color.Black, if(isSystemInDarkTheme()) Color.LightGray else Color.Black, modifier = Modifier.padding(start = 10.dp))
        Spacer(
            Modifier.weight(1f)
        )
        Checkbox(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(checkedColor = PokeRed)

        )

    }
}

@Composable
@Preview
fun SettingsCheckboxPreview() {
    SettingsCheckbox(text = "Prueba", modifier = Modifier, true) { }
}

