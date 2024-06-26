package com.xramos.mycomics.ui.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.xramos.mycomics.R
import com.xramos.mycomics.domain.model.model.CharacterModel
import com.xramos.mycomics.domain.model.model.getPowers
import com.xramos.mycomics.ui.component.CharacterHeader
import com.xramos.mycomics.ui.component.ComicsTopAppBar
import com.xramos.mycomics.ui.theme.MyComicsTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navigateBack: () -> Unit,
                 modifier: Modifier = Modifier,
                 characterId: Int,
                 viewModel: DetailViewModel = hiltViewModel()
) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val coroutineScope = rememberCoroutineScope()

    MyComicsTheme {

        Scaffold(
            modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {

                ComicsTopAppBar(
                    canNavigateBack = true,
                    scrollBehavior = scrollBehavior,
                    navigateUp = { navigateBack() })

            }, floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        coroutineScope.launch {
                            viewModel.updateFavorite(characterId)
                        }
                    },
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.padding(20.dp)) {

                    Icon(imageVector = when(viewModel.isFavorite) {
                        true -> Icons.Default.Favorite
                        false -> Icons.Default.FavoriteBorder
                    },
                        contentDescription = "Add/Remove Favorite")
                }
            }) {

            LaunchedEffect(characterId) {
                viewModel.getCharacter(characterId)
            }

            val character by viewModel.characterModel.collectAsState()

            DetailContent(modifier = Modifier.padding(it),
                character = character)
        }
    }
}

@Composable
fun DetailContent(modifier: Modifier,
                  character: CharacterModel?) {

    character?.let {

        Column(modifier = modifier.verticalScroll(rememberScrollState())) {

            Header(character)

            Body(character)
        }
    }
}

@Composable
fun Header(character: CharacterModel) {

    Card(modifier = Modifier
        .padding(dimensionResource(id = R.dimen.padding_small))
        .fillMaxWidth()
        .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.elevation)
        )
    ) {

        CharacterHeader(
            modifier = Modifier
                .size(120.dp, 120.dp)
                .padding(dimensionResource(id = R.dimen.padding_small)),
            character = character,
            url = character.image.superUrl)
    }
}

@Composable
fun Body(character: CharacterModel) {

    Card(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_small))
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.elevation)
        )
    ) {

        character.birth?.let {
            TitleComponent(
                title = stringResource(id = R.string.birth),
                value = it
            )
        }

        TitleComponent(
            title = stringResource(id = R.string.gender),
            value = character.gender.printableName
        )

        TitleComponent(
            title = stringResource(id = R.string.origin),
            value = character.origin
        )

        character.aliases?.let {
            InfoComponent(
                title = stringResource(id = R.string.alias),
                value = it
            )
        }

        InfoComponent(
            title = stringResource(id = R.string.powers),
            value = character.getPowers()
        )

        character.deck?.let {
            InfoComponent(
                title = stringResource(id = R.string.description),
                value = it
            )
        }
    }
}

@Composable
fun TitleComponent(title: String, value: String) {

    Row(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_small))
    ) {

        Text(
            text = title,
            textAlign = TextAlign.Left,
            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(end = dimensionResource(id = R.dimen.padding_small))
        )

        Text(
            text = value,
            textAlign = TextAlign.Right,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun InfoComponent(title: String, value: String) {

    Column(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_small))
    ) {

        Text(
            title,
            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)
        )

        Text(
            value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}