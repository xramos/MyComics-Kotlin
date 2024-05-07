package com.xramos.mycomics.ui.component

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.xramos.mycomics.domain.model.model.CharacterModel

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ListItemCharacter(item: CharacterModel,
                      onClick: (id: Int) -> Unit) {

    val painter = rememberImagePainter(data = item.image.smallUrl) {
        crossfade(1000)
        //error drawable
        //placeholder drawable
    }

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
            verticalAlignment = Alignment.CenterVertically
            ) {

            Image(painter = painter,
                contentDescription = null,
                modifier = Modifier.size(80.dp, 80.dp).padding(8.dp),
                contentScale = ContentScale.Fit)

            Column(Modifier.padding(8.dp)) {
                Text(
                    text = item.name,
                    fontSize = 24.sp,
                    style = TextStyle(
                        color = Color.Black,
                    ),
                )
                Row {
                    item.realName?.let {
                        Text(
                            text = it,
                            fontSize = 16.sp,
                            style = TextStyle(
                                color = Color.Black,
                            ),
                        )
                    }
                }
            }
        }
    }
}