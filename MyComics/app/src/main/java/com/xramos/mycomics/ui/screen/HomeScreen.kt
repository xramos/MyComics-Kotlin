package com.xramos.mycomics.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.xramos.mycomics.ui.component.Header
import com.xramos.mycomics.ui.component.InputSearch
import com.xramos.mycomics.ui.theme.MyComicsTheme

@Composable
fun HomeScreen(
    navController: NavHostController
) {

   MyComicsTheme {

       Surface {

           HomeContent()
       }
   }
}

@Composable
fun HomeContent() {

    Column {

        Header()

        InputSearch(
            text = "",
            onTextChange = {

            }, onSearchClicked = {

            }, onCloseClicked = {

            })
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

            HomeContent()
        }
    }
}