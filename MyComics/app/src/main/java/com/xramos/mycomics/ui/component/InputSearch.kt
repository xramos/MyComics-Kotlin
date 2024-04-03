package com.xramos.mycomics.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun InputSearch(text: String,
                onTextChange: (String) -> Unit,
                onSearchClicked: (String) -> Unit,
                onCloseClicked: () -> Unit) {

    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        TextField(
            value = text,
            onValueChange = { value ->
                onTextChange(value)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .border(
                    width = 1.5f.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                ),
            textStyle = MaterialTheme.typography.bodyMedium,
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(24.dp),
                    tint = MaterialTheme.colorScheme.primary)
            },
            trailingIcon = {
                if (text.isNotEmpty()) {
                    IconButton(onClick = {
                        keyboardController?.hide()
                        onTextChange("")
                        onCloseClicked()
                    }) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = "",
                            modifier = Modifier
                                .padding(8.dp)
                                .size(24.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    if (text.trim().isNotEmpty()) {
                        keyboardController?.hide()
                        onSearchClicked(text)
                    }
                }
            ),
            singleLine = true
        )
    }
}