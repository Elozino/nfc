package com.example.nativesentrystride.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppTextInput(modifier: Modifier = Modifier, value: String = "") {
    var isFocused by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = value,
        onValueChange = {},
        label = { if (!isFocused) Text(text = "Enter placeholder") },
        trailingIcon = {
            Icon(imageVector = Icons.Filled.AccountBox, contentDescription = null)
        },
        modifier = Modifier.onFocusChanged { isFocused = it.isFocused }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppTextInputPreview() {
    AppTextInput()
}
