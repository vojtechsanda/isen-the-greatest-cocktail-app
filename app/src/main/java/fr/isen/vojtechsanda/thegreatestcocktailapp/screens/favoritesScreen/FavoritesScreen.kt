package fr.isen.vojtechsanda.thegreatestcocktailapp.screens.favoritesScreen

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import fr.isen.vojtechsanda.thegreatestcocktailapp.DrinkDetailActivity
import fr.isen.vojtechsanda.thegreatestcocktailapp.R
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.CategoryData
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.DrinkDetailData
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.IngredientData
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.favoritesScreen.views.FavoritesTopAppBar
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.columnItemCard.ColumnItemCardView
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.layout.appScaffold.AppScaffold

@Composable
fun FavoritesScreen(modifier: Modifier = Modifier, withBottomBar: Boolean = false) {
    val drinks = listOf(
        DrinkDetailData(
            id = "super-cocktail",
            imageUrl = "https://example.com/example.png",
            name = "Super cocktail",
            categories = listOf(
                CategoryData(
                    id = "other-unknown",
                    name = "Other / Unknown",
                    iconVector = Icons.Default.Info,
                    backgroundFromRes = (R.color.light_blue),
                    backgroundToRes = (R.color.dark_blue)
                ),

                CategoryData(
                    id = "non-alcoholic",
                    name = "Non alcoholic",
                    iconVector = Icons.Default.Warning,
                    backgroundFromRes = (R.color.muted_sage),
                    backgroundToRes = (R.color.dark_forest_green)
                ),

                CategoryData(
                    id = "highball-glass",
                    name = "Highball glass",
                    iconVector = Icons.Default.Star,
                    backgroundFromRes = (R.color.transparent),
                    backgroundToRes = (R.color.transparent),
                    textColorRes = (R.color.teal_200),
                )
            ),

            ingredients = listOf(
                IngredientData(
                    name = "Yoghurt",
                    amount = "2 cups",
                ),
                IngredientData(
                    name = "Fruit",
                    amount = "1 piece",
                )
            ),

            recipe = "This is some very interesting recipe on how to do the Super cocktail.",
        )
    )

    val context = LocalContext.current
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

                items(drinks) { drink ->
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
