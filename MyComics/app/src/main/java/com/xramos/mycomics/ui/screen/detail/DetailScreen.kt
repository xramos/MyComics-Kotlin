package com.xramos.mycomics.ui.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.xramos.mycomics.domain.model.model.CharacterModel
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

        Column {

            it.deck?.let {
                it1 -> Text(it1)
            }

            it.aliases?.let {
                it1 -> Text(text = it1)
            }
        }
    }
}