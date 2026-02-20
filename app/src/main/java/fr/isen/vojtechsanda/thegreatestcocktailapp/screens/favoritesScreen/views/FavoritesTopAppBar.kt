package fr.isen.vojtechsanda.thegreatestcocktailapp.screens.favoritesScreen.views


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import fr.isen.vojtechsanda.thegreatestcocktailapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesTopAppBar() {
    TopAppBar(
        title = {
            Text(stringResource(R.string.favorites))
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(R.color.deep_midnight_purple),
            titleContentColor = colorResource(R.color.white),
        ),
    )
}
