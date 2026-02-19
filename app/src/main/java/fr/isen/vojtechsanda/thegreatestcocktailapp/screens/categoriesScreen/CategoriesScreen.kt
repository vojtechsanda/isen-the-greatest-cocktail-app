package fr.isen.vojtechsanda.thegreatestcocktailapp.screens.categoriesScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.thegreatestcocktailapp.R
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.CategoryData
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.categoriesScreen.views.CategoriesTopAppBar
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.columnItemCard.ColumnItemCardView
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.layout.appScaffold.AppScaffold

@Composable
fun CategoriesScreen() {
    val categories = listOf(
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
    );

    AppScaffold(
        topBar = { CategoriesTopAppBar() },
        content = { childModifier ->
            LazyColumn(
                modifier = childModifier,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {

                items(categories) { category ->
                    ColumnItemCardView(
                        title = category.text,

                        leading = {
                            Icon(
                                imageVector = category.iconVector,
                                contentDescription = ""
                            )
                        }
                    )
                }
            }
        })
}
