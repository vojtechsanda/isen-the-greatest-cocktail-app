package fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinksScreen

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import fr.isen.vojtechsanda.thegreatestcocktailapp.DrinkDetailActivity
import fr.isen.vojtechsanda.thegreatestcocktailapp.dtos.toDrinkPreviewData
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.DrinkPreviewData
import fr.isen.vojtechsanda.thegreatestcocktailapp.network.ApiClient
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinksScreen.views.DrinksTopAppBar
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.columnItemCard.ColumnItemCardView
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.layout.appScaffold.AppScaffold

@Composable
fun DrinksScreen(
    categoryId: String,
    modifier: Modifier = Modifier,
    withBottomBar: Boolean = false
) {
    val drinksState = remember { mutableStateOf<List<DrinkPreviewData>>(emptyList()) }

    LaunchedEffect(Unit) {
        try {
            val response = ApiClient.retrofit.getDrinksForCategory(categoryId)

            drinksState.value =
                response.drinks.map { drink -> drink.toDrinkPreviewData() }
        } catch (e: Exception) {
            Log.e("DrinksScreen", "Error fetching categories", e)
        }
    }


    val context = LocalContext.current
    val drinkDetailIntent = Intent(context, DrinkDetailActivity::class.java)

    AppScaffold(
        withBottomBar = withBottomBar,
        topBar = { DrinksTopAppBar() },
        content = { childModifier ->
            LazyColumn(
                modifier = childModifier
                    .then(modifier),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                contentPadding = PaddingValues(20.dp, 8.dp, 20.dp, 20.dp)
            ) {

                items(items = drinksState.value) { drink ->
                    ColumnItemCardView(
                        modifier = Modifier.clickable {
                            drinkDetailIntent.putExtra("DRINK_ID", drink.id)
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
