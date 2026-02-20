package fr.isen.vojtechsanda.thegreatestcocktailapp.screens.categoriesScreen

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.thegreatestcocktailapp.DrinksActivity
import fr.isen.vojtechsanda.thegreatestcocktailapp.dtos.toCategoryPreviewData
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.CategoryPreviewData
import fr.isen.vojtechsanda.thegreatestcocktailapp.network.ApiClient
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.categoriesScreen.views.CategoriesTopAppBar
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.columnItemCard.ColumnItemCardView
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.layout.appScaffold.AppScaffold

@Composable
fun CategoriesScreen(modifier: Modifier = Modifier, withBottomBar: Boolean = false) {
    val categoriesState = remember { mutableStateOf<List<CategoryPreviewData>>(emptyList()) }

    LaunchedEffect(Unit) {
        try {
            val response = ApiClient.retrofit.getCategories()

            categoriesState.value =
                response.drinks.map { category -> category.toCategoryPreviewData() }
        } catch (e: Exception) {
            Log.e("CategoriesScreen", "Error fetching categories", e)
        }
    }

    val context = LocalContext.current
    val drinksIntent = Intent(context, DrinksActivity::class.java)

    AppScaffold(
        withBottomBar = withBottomBar,
        topBar = { CategoriesTopAppBar() },
        content = { childModifier ->
            LazyColumn(
                modifier = childModifier
                    .then(modifier),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                contentPadding = PaddingValues(20.dp, 8.dp, 20.dp, 20.dp)
            ) {
                items(items = categoriesState.value) { category ->
                    ColumnItemCardView(
                        modifier = Modifier.clickable {
                            drinksIntent.putExtra("CATEGORY_ID", category.id)
                            context.startActivity(drinksIntent)
                        },
                        title = category.name,
                        leading = {
                            Icon(
                                imageVector = Icons.Filled.Info,
                                contentDescription = ""
                            )
                        }
                    )
                }
            }
        })
}
