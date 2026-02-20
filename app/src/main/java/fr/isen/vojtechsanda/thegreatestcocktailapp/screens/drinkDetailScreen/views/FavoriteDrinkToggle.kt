package fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinkDetailScreen.views

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.thegreatestcocktailapp.R
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.DrinkDetailData
import fr.isen.vojtechsanda.thegreatestcocktailapp.storage.FavoritesSharedPreferencesManager
import kotlinx.coroutines.launch

@Composable
fun FavoriteDrinkToggle(drink: DrinkDetailData) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val favoritesManager = FavoritesSharedPreferencesManager();

    val favoriteDrinksIdsState =
        favoritesManager.getFavoriteDrinksFlow(context).collectAsState(initial = setOf());

    val isFavorite = drink.id in favoriteDrinksIdsState.value

    IconButton(onClick = {
        coroutineScope.launch {
            favoritesManager.toggleFavoriteDrink(context, drink.id)
        }
    }) {
        Icon(
            tint = colorResource(R.color.red),
            modifier = Modifier.size(32.dp),
            imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
            contentDescription = if (isFavorite) stringResource(R.string.add_to_favorites) else stringResource(
                R.string.remove_from_favorites
            )
        )
    }
}
