package fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinksScreen

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.thegreatestcocktailapp.R
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.CategoryData
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.DrinkData
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.IngredientData
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.IngredientUnitEnum
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinksScreen.views.DrinksTopAppBar
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.columnItemCard.ColumnItemCardView
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.layout.appScaffold.AppScaffold

@Composable
fun DrinksScreen() {
    val drinks = listOf(
        DrinkData(
            image = painterResource(R.drawable.test_cocktail_detail),
            name = "Super cocktail",
            categories = listOf(
                CategoryData(
                    text = "Other / Unknown",
                    iconVector = Icons.Default.Info,
                    backgroundFrom = colorResource(R.color.light_blue),
                    backgroundTo = colorResource(R.color.dark_blue)
                ),

                CategoryData(
                    text = "Non alcoholic",
                    iconVector = Icons.Default.Warning,
                    backgroundFrom = colorResource(R.color.muted_sage),
                    backgroundTo = colorResource(R.color.dark_forest_green)
                ),

                CategoryData(
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

    AppScaffold(
        topBar = { DrinksTopAppBar() },
        content = { childModifier ->
            LazyColumn(
                modifier = childModifier,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {

                items(drinks) { drink ->
                    ColumnItemCardView(
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
