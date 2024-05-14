package com.xramos.mycomics.ui.screen.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.xramos.mycomics.navigation.Screen
import com.xramos.mycomics.ui.component.Header
import com.xramos.mycomics.ui.component.InputSearch
import com.xramos.mycomics.ui.component.ListItemCharacter
import com.xramos.mycomics.ui.theme.MyComicsTheme

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {

   MyComicsTheme {

       Surface {

           HomeContent(navController = navController,
               viewModel = viewModel)
       }
   }
}

@Composable
fun HomeContent(navController: NavHostController,
                viewModel: HomeViewModel
) {

    val searchQuery by viewModel.searchQuery
    val searchedCharacters = viewModel.searchedCharacters.collectAsState()

    Column {

        Header()

        InputSearch(
            text = searchQuery,
            onTextChange = {
                viewModel.updateSearchQuery(it)
            }, onSearchClicked = {
                viewModel.searchCharacters(it)
            }, onCloseClicked = {
                viewModel.setSearch(false)
            })

        LazyColumn(
            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 8.dp
            )
        ) {

            items(searchedCharacters.value) { character ->

                ListItemCharacter(item = character,
                        onClick = {
                            val route = "${Screen.Detail.route}/${it}"
                            navController.navigate(route)
                        })
            }
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Default Preview Dark"
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Default Preview Light"
)
@Composable
fun HomePreview() {

    MyComicsTheme {

        Surface {

            Column {

                Header()
            }
        }
    }
}