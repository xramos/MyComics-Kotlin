package com.xramos.mycomics.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.xramos.mycomics.ui.component.ComicsTopAppBar
import com.xramos.mycomics.ui.component.InputSearch
import com.xramos.mycomics.ui.component.ListItemCharacter
import com.xramos.mycomics.ui.theme.MyComicsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToCharacter: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    MyComicsTheme {

        Scaffold(
            modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {

                ComicsTopAppBar(
                    title = "My Comics",
                    canNavigateBack = false,
                    scrollBehavior = scrollBehavior)

            }) { innerPadding ->

            HomeBody(
                navigateToCharacter = navigateToCharacter,
                viewModel = viewModel,
                contentPadding = innerPadding
            )
        }
    }
}

@Composable
fun HomeBody(navigateToCharacter: (Int) -> Unit,
             viewModel: HomeViewModel,
             contentPadding: PaddingValues = PaddingValues(0.dp)
) {

    val searchQuery by viewModel.searchQuery
    val searchedCharacters = viewModel.searchedCharacters.collectAsState()

    Column(
        modifier = Modifier.padding(contentPadding)
    ) {

        InputSearch(
            text = searchQuery,
            onTextChange = {
                viewModel.updateSearchQuery(it)
            }, onSearchClicked = {
                viewModel.searchCharacters(it)
            }, onCloseClicked = {
                viewModel.setSearch(false)
            })

        LazyColumn {

            items(searchedCharacters.value) { character ->

                ListItemCharacter(character = character,
                        onClick = {
                            navigateToCharacter(it)
                        })
            }
        }
    }
}