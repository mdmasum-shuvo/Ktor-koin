package com.appifly.ktor.ui.screen

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.appifly.ktor.ui.component.TextFieldWithBorder

@Composable
fun SearchScreen() {
    val input = remember {
        mutableStateOf("")
    }
    Surface {
        TextFieldWithBorder(inputValue = input, placeholder = "User ID")

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}