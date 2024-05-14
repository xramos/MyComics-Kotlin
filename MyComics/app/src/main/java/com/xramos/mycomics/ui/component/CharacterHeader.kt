package com.xramos.mycomics.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun CharacterHeader(modifier: Modifier = Modifier,
                    character: CharacterModel,
                    url: String) {

    val painter = rememberImagePainter(data = url) {
        crossfade(1000)
        //error drawable
        //placeholder drawable
    }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(painter = painter,
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.Fit)

        Column(Modifier.padding(8.dp)) {
            Text(
                text = character.name,
                fontSize = 24.sp,
                style = TextStyle(
                    color = Color.Black,
                ),
            )
            Row {
                character.realName?.let {
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