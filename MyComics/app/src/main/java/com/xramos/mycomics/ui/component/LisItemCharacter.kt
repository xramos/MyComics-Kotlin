package com.xramos.mycomics.ui.component

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xramos.mycomics.domain.model.model.CharacterModel

@Composable
fun ListItemCharacter(item: CharacterModel,
                      onClick: (id: Int) -> Unit) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onClick(item.id.toInt()) },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Row(
            Modifier.background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF663399),
                        Color(0xFF4066E0),
                    )
                )
            ),
            verticalAlignment = Alignment.CenterVertically,

            ) {

            // TODO: Add Coil library and then add AsyncImage

            Column(Modifier.padding(8.dp)) {
                Text(
                    text = item.name,
                    fontSize = 24.sp,
                    style = TextStyle(
                        color = Color.White,
                    ),
                )
                Row {
                    Text(
                        text = "Real Name ",
                        style = TextStyle(
                            color = Color.White,
                        ),
                    )
                    item.realName?.let {
                        Text(
                            text = it,
                            style = TextStyle(
                                color = Color.White,
                            ),
                        )
                    }
                }
            }
        }
    }
}