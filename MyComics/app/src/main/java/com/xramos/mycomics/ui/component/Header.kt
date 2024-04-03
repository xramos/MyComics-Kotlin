package com.xramos.mycomics.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp

@Composable
fun Header() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "My Comics",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = MaterialTheme.colorScheme.secondary,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontStyle = MaterialTheme.typography.titleLarge.fontStyle,
            fontFamily = FontFamily.Serif
        )

        Spacer(modifier = Modifier.height(8.dp))
    }
}