package com.example.pokedescifrarcompose.ui.screens.game

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.pokedescifrarcompose.R
import com.example.pokedescifrarcompose.data.viewmodel.BottomBarViewModel
import com.example.pokedescifrarcompose.ui.screens.PokeDescifrarUI
import com.example.pokedescifrarcompose.ui.theme.PokeRed
import com.example.pokedescifrarcompose.ui.theme.pixeloidSansFamily


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokeTextField(
    userGuess: String,
    onUserGuessChanged: (String) -> Unit,
    isGuessWrong: Boolean,
    onKeyBoardDone: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = userGuess,
        singleLine = true,
        shape = shapes.large,
        modifier = modifier.fillMaxWidth(),
        onValueChange = onUserGuessChanged,
        textStyle = TextStyle(
            fontFamily = pixeloidSansFamily
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = PokeRed,
            unfocusedBorderColor = PokeRed,
            errorBorderColor = Color.Yellow,
            errorLabelColor = Color.Yellow
        ),
        label = {
            if(isGuessWrong) {
                Text(text = stringResource(R.string.wrong_word_esp), fontFamily = pixeloidSansFamily, color = Color.White, modifier = Modifier)
            } else {
                Text(text = stringResource(R.string.enter_word_esp), fontFamily = pixeloidSansFamily, color = Color.White, modifier = Modifier)
            }
        },
        isError = isGuessWrong,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {onKeyBoardDone()}
        )
    )
}

@Composable
@Preview
fun PokeTextFieldPreview() {
    PokeDescifrarUI(navigation = rememberNavController(), bottomBarViewModel = BottomBarViewModel()) {
        PokeTextField(
            userGuess = "a",
            onUserGuessChanged = {},
            isGuessWrong = true,
            onKeyBoardDone = { /*TODO*/ })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun OutlineTest() {
    Surface(color = Color.White) {
        OutlinedTextField(
            value = "Input here",
            onValueChange = {},
            label = {Text(text = "Test")},
            modifier = Modifier.fillMaxWidth()
        )
    }

}