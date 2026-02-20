package fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinkDetailScreen

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import fr.isen.vojtechsanda.thegreatestcocktailapp.R
import fr.isen.vojtechsanda.thegreatestcocktailapp.dtos.toDrinkDetailData
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.DrinkDetailData
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.IngredientData
import fr.isen.vojtechsanda.thegreatestcocktailapp.network.ApiClient
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinkDetailScreen.views.DrinkDetailCategoryView
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinkDetailScreen.views.DrinkDetailTopAppBar
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.infoCard.InfoCardText
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.infoCard.InfoCardView
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.layout.appScaffold.AppScaffold

@Composable
fun DrinkDetailScreen(
    drinkId: String? = null,
    modifier: Modifier = Modifier,
    withBottomBar: Boolean = false
) {
    val drinkState = remember { mutableStateOf<DrinkDetailData?>(null) }

    LaunchedEffect(Unit) {
        try {
            val response = if (drinkId == null) {
                ApiClient.retrofit.getRandomDrink()
            } else {
                ApiClient.retrofit.getDrinkDetail(drinkId)
            }
            val drinkDTO = response.drinks.firstOrNull()

            if (drinkDTO != null) {
                drinkState.value = drinkDTO.toDrinkDetailData()
            }
        } catch (e: Exception) {
            Log.e("DrinkDetailScreen", "Error fetching categories", e)
        }
    }

    AppScaffold(
        withBottomBar = withBottomBar,
        verticalScrolling = true,
        topBar = { DrinkDetailTopAppBar(drinkState.value) },
        content = { childModifier ->
            if (drinkState.value != null)
                Column(
                    modifier = childModifier
                        .then(modifier)
                        .padding(PaddingValues(20.dp, 8.dp, 20.dp, 20.dp)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    ImageView(drinkState.value!!.imageUrl)

                    Text(drinkState.value!!.name, fontSize = 40.sp, fontWeight = FontWeight.Bold)

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(
                            20.dp,
                            Alignment.CenterHorizontally
                        ),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        drinkState.value!!.categories.map { DrinkDetailCategoryView(category = it) }
                    }

                    InfoCardView(
                        title = stringResource(R.string.ingredients),
                        titleIconVector = Icons.AutoMirrored.Filled.List,
                        content = { drinkState.value!!.ingredients.map { IngredientView(it) } }
                    )

                    InfoCardView(
                        title = stringResource(R.string.recipe),
                        titleIconVector = Icons.Default.Info,
                        content = {
                            InfoCardText(
                                text = drinkState.value!!.recipe
                                    ?: stringResource(R.string.no_recipe_found)
                            )
                        },
                    )
                }
        })
}

@Composable
fun ImageView(imageUrl: String?) {
    if (imageUrl != null)
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
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
            InfoCardText(ingredient.amount ?: "")
        }
    }
}
