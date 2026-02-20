package fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinksScreen

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.thegreatestcocktailapp.DrinkDetailActivity
import fr.isen.vojtechsanda.thegreatestcocktailapp.R
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.CategoryData
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.DrinkData
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.IngredientData
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.IngredientUnitEnum
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinksScreen.views.DrinksTopAppBar
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.columnItemCard.ColumnItemCardView
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.layout.appScaffold.AppScaffold

@Composable
fun DrinksScreen(categoryId: String) {
    val drinks = listOf(
        DrinkData(
            id = "super-cocktail",
            image = painterResource(R.drawable.test_cocktail_detail),
            name = "Super cocktail",
            categories = listOf(
                CategoryData(
                    id = "other-unknown",
                    text = "Other / Unknown",
                    iconVector = Icons.Default.Info,
                    backgroundFrom = colorResource(R.color.light_blue),
                    backgroundTo = colorResource(R.color.dark_blue)
                ),

                CategoryData(
                    id = "non-alcoholic",
                    text = "Non alcoholic",
                    iconVector = Icons.Default.Warning,
                    backgroundFrom = colorResource(R.color.muted_sage),
                    backgroundTo = colorResource(R.color.dark_forest_green)
                ),

                CategoryData(
                    id = "highball-glass",
                    text = "Highball glass",
                    iconVector = Icons.Default.Star,
                    backgroundFrom = colorResource(R.color.transparent),
                    backgroundTo = colorResource(R.color.transparent),
                    textColor = colorResource(R.color.teal_200)
                )
            ),

            ingredients = listOf(
                IngredientData(
                    name = "Yoghurt",
                    amount = 2.0,
                    unit = IngredientUnitEnum.CUP
                ),
                IngredientData(
                    name = "Fruit",
                    amount = 1.0,
                    unit = IngredientUnitEnum.PIECE
                )
            ),

            recipe = "This is some very interesting recipe on how to do the Super cocktail.",

            isFavorite = true
        )
    );

    val context = LocalContext.current
    val drinkDetailIntent = Intent(context, DrinkDetailActivity::class.java)

    AppScaffold(
        topBar = { DrinksTopAppBar() },
        content = { childModifier ->
            LazyColumn(
                modifier = childModifier,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {

                items(drinks) { drink ->
                    ColumnItemCardView(
                        modifier = Modifier.clickable {
                            drinkDetailIntent.putExtra("DRINK_ID", drink.id)
                            context.startActivity(drinkDetailIntent)
                        },
                        title = drink.name,
                        leading = {
                            Image(
                                painter = drink.image,
                                "",
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
