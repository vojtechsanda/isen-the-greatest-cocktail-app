package fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinkDetailScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.vojtechsanda.thegreatestcocktailapp.R
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.CategoryData
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.DrinkData
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.IngredientData
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.IngredientUnitEnum
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinkDetailScreen.views.DrinkDetailCategoryView
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinkDetailScreen.views.DrinkDetailTopAppBar
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.infoCard.InfoCardText
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.infoCard.InfoCardView
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.layout.appScaffold.AppScaffold

@Composable
fun DrinkDetailScreen(drinkId: String? = null) {
    val cocktail = DrinkData(
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

    AppScaffold(
        verticalScrolling = true,
        topBar = { DrinkDetailTopAppBar(cocktail) },
        content = { childModifier ->
            Column(
                modifier = childModifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                ImageView(cocktail.image)

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
                    content = { InfoCardText(cocktail.recipe) },
                )
            }
        })
}

@Composable
fun ImageView(image: Painter) {
    Image(
        painter = image,
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
}

@Composable
fun IngredientView(ingredient: IngredientData) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        InfoCardText(ingredient.name)

        Row {
            InfoCardText("${ingredient.amount} ${ingredient.unit}")
        }
    }
}
