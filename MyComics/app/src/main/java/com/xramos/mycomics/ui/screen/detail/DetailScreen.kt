package com.xramos.mycomics.ui.screen.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.xramos.mycomics.domain.model.model.CharacterModel
import com.xramos.mycomics.domain.model.model.getPowers
import com.xramos.mycomics.ui.component.CharacterHeader
import com.xramos.mycomics.ui.theme.MyComicsTheme

@Composable
fun DetailScreen(navController: NavHostController,
                 characterId: Int,
                 viewModel: DetailViewModel = hiltViewModel()
) {

    MyComicsTheme {

        LaunchedEffect(characterId) {
            viewModel.getCharacter(characterId)
        }

        val character by viewModel.characterModel.collectAsState()

        DetailContent(character = character)
    }
}

@Composable
fun DetailContent(character: CharacterModel?) {

    character?.let {

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

            Header(character)

            Body(character)
        }
    }
}

@Composable
fun Header(character: CharacterModel) {

    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
        ) {

        CharacterHeader(
            modifier = Modifier
                .size(120.dp, 120.dp)
                .padding(8.dp),
            character = character,
            url = character.image.superUrl)
    }
}

@Composable
fun Body(character: CharacterModel) {

        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = MaterialTheme.shapes.medium,
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
        ) {

            character.birth?.let {
                TitleComponent(title = "Birth:", value = it)
            }

            TitleComponent(title = "Gender:", value = character.gender.printableName)

            TitleComponent(title = "Origin:", value = character.origin)

            character.aliases?.let {
                TitleComponent(title = "Alias:", value = it)
            }

            InfoComponent(title = "Powers:", value = character.getPowers())

            character.deck?.let {
                InfoComponent(title = "Description:", value = it)
            }
        }
}

@Composable
fun TitleComponent(title: String, value: String) {

    Row(modifier = Modifier
        .padding(8.dp)) {

        Text(text = title,
            textAlign = TextAlign.Left,
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))

        Text(text = value,
            textAlign = TextAlign.Right,
            style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun InfoComponent(title: String, value: String) {

    Column(modifier = Modifier
        .padding(8.dp)) {

        Text(title,
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))

        Text(value,
            style = MaterialTheme.typography.bodyMedium)
    }
}