package fr.isen.vojtechsanda.thegreatestcocktailapp.screens.categoriesScreen

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.thegreatestcocktailapp.DrinksActivity
import fr.isen.vojtechsanda.thegreatestcocktailapp.R
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.CategoryData
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.categoriesScreen.views.CategoriesTopAppBar
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.columnItemCard.ColumnItemCardView
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.layout.appScaffold.AppScaffold

@Composable
fun CategoriesScreen() {
    val categories = listOf(
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
    );

    val context = LocalContext.current
    val drinksIntent = Intent(context, DrinksActivity::class.java)

    AppScaffold(
        topBar = { CategoriesTopAppBar() },
        content = { childModifier ->
            LazyColumn(
                modifier = childModifier,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {

                items(categories) { category ->
                    ColumnItemCardView(
                        modifier = Modifier.clickable {
                            drinksIntent.putExtra("CATEGORY_ID", category.id)
                            context.startActivity(drinksIntent)
                        },
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
