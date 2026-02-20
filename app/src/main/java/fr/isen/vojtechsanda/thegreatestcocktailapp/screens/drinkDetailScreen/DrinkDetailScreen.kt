package fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinkDetailScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.vojtechsanda.thegreatestcocktailapp.R
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.CategoryData
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.DrinkData
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.IngredientData
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinkDetailScreen.views.DrinkDetailCategoryView
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinkDetailScreen.views.DrinkDetailTopAppBar
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.infoCard.InfoCardText
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.infoCard.InfoCardView
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.layout.appScaffold.AppScaffold

@Composable
fun DrinkDetailScreen(drinkId: String? = null, modifier: Modifier = Modifier) {
    val cocktail = DrinkData(
        id = "super-cocktail",
        imageUrl = "https://example.com/example.png",
        name = "Super cocktail",
        categories = listOf(
            CategoryData(
                id = "other-unknown",
                name = "Other / Unknown",
                iconVector = Icons.Default.Info,
                backgroundFromRes = R.color.light_blue,
                backgroundToRes = R.color.dark_blue
            ),

            CategoryData(
                id = "non-alcoholic",
                name = "Non alcoholic",
                iconVector = Icons.Default.Warning,
                backgroundFromRes = R.color.muted_sage,
                backgroundToRes = R.color.dark_forest_green
            ),

            CategoryData(
                id = "highball-glass",
                name = "Highball glass",
                iconVector = Icons.Default.Star,
                backgroundFromRes = R.color.transparent,
                backgroundToRes = R.color.transparent,
                textColorRes = R.color.teal_200,
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

        isFavorite = true
    )

    AppScaffold(
        verticalScrolling = true,
        topBar = { DrinkDetailTopAppBar(cocktail) },
        content = { childModifier ->
            Column(
                modifier = childModifier.then(modifier),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                ImageView(cocktail.imageUrl)

                Text(cocktail.name, fontSize = 40.sp, fontWeight = FontWeight.Bold)

                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(
                        20.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    cocktail.categories.map { DrinkDetailCategoryView(category = it) }
                }

                InfoCardView(
                    title = stringResource(R.string.ingredients),
                    titleIconVector = Icons.AutoMirrored.Filled.List,
                    content = { cocktail.ingredients.map { IngredientView(it) } }
                )

                InfoCardView(
                    title = stringResource(R.string.recipe),
                    titleIconVector = Icons.Default.Info,
                    content = {
                        InfoCardText(
                            text = cocktail.recipe ?: stringResource(R.string.no_recipe_found)
                        )
                    },
                )
            }
        })
}

@Composable
fun ImageView(imageUrl: String?) {
    // TODO: Connect the URL

    if (imageUrl != null) Text(imageUrl) else null

    /*
    Image(
        painter = painterResource(R.drawable.cocktail),
        "Test Cocktail",
        modifier = Modifier
            .clip(CircleShape)
            .fillMaxWidth(0.7f)
            .border(
                width = 2.dp,
                color = colorResource(R.color.teal_700),
                shape = CircleShape
            )
    )
    */
}

@Composable
fun IngredientView(ingredient: IngredientData) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        InfoCardText(ingredient.name)

        Row {
            InfoCardText(ingredient.amount ?: "")
        }
    }
}
