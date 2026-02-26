package fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinkDetailScreen.views

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import fr.isen.vojtechsanda.thegreatestcocktailapp.R
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.DrinkDetailData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrinkDetailTopAppBar(drink: DrinkDetailData?) {
    TopAppBar(
        title = {
            Text("${stringResource(R.string.cocktail)} ${drink?.name}")
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(R.color.deep_midnight_purple),
            titleContentColor = colorResource(R.color.white),
        ),
        actions = {
            if (drink != null)
                FavoriteDrinkToggle(drink)
        }
    )
}
