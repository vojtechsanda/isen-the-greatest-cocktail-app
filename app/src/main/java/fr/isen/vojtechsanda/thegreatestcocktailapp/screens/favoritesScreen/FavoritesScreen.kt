package fr.isen.vojtechsanda.thegreatestcocktailapp.screens.favoritesScreen

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import fr.isen.vojtechsanda.thegreatestcocktailapp.DrinkDetailActivity
import fr.isen.vojtechsanda.thegreatestcocktailapp.dtos.toDrinkDetailData
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.DrinkDetailData
import fr.isen.vojtechsanda.thegreatestcocktailapp.network.ApiClient
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.favoritesScreen.views.FavoritesTopAppBar
import fr.isen.vojtechsanda.thegreatestcocktailapp.storage.FavoritesSharedPreferencesManager
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.columnItemCard.ColumnItemCardView
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.layout.appScaffold.AppScaffold
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll

@Composable
fun FavoritesScreen(modifier: Modifier = Modifier, withBottomBar: Boolean = false) {
    val context = LocalContext.current
    val favoritesManager = FavoritesSharedPreferencesManager()
    val favoriteDrinksIdsState =
        favoritesManager.getFavoriteDrinksFlow(context).collectAsState(initial = setOf())

    val drinksState = remember { mutableStateOf<List<DrinkDetailData>>(emptyList()) }

    LaunchedEffect(favoriteDrinksIdsState.value) {
        try {
            val drinksDetails = favoriteDrinksIdsState.value.toList().map { drinkId ->
                async {
                    ApiClient.retrofit.getDrinkDetail(drinkId)
                }
            }.awaitAll()
                .flatMap { response -> response.drinks.map { drink -> drink.toDrinkDetailData() } }

            drinksState.value = drinksDetails
        } catch (e: Exception) {
            Log.e("FavoritesScreen", "Error fetching drinks details", e)
        }
    }


    val drinkDetailIntent = Intent(context, DrinkDetailActivity::class.java)

    AppScaffold(
        withBottomBar = withBottomBar,
        topBar = { FavoritesTopAppBar() },
        content = { childModifier ->
            LazyColumn(
                modifier = childModifier
                    .then(modifier),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                contentPadding = PaddingValues(20.dp, 8.dp, 20.dp, 20.dp)
            ) {
                if (drinksState.value.isEmpty())
                    item {
                        Text("No favorites yet")
                    }
                else
                    items(drinksState.value) { drink ->
                        ColumnItemCardView(
                            modifier = Modifier.clickable {
                                drinkDetailIntent.putExtra(
                                    DrinkDetailActivity.EXTRA_DRINK_ID,
                                    drink.id
                                )
                                context.startActivity(drinkDetailIntent)
                            },
                            title = drink.name,
                            leading = {
                                if (drink.imageUrl != null)
                                    AsyncImage(
                                        model = drink.imageUrl,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .width(48.dp)
                                    )
                            }
                        )
                    }
            }
        })
}
