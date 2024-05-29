package com.xramos.mycomics.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.xramos.mycomics.R
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

        Image(
            modifier = modifier
                .clip(MaterialTheme.shapes.large),
            contentScale = ContentScale.Crop,
            painter = painter,
            contentDescription = null
        )

        Column(Modifier.padding(dimensionResource(id = R.dimen.padding_small))) {
            Text(
                text = character.name,
                style = MaterialTheme.typography.titleLarge
            )
            Row {
                character.realName?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}