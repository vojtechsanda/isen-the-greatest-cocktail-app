package fr.isen.vojtechsanda.thegreatestcocktailapp.models

import androidx.compose.ui.graphics.painter.Painter

data class CocktailData(
    val image: Painter,
    val name: String,
    val categories: List<CategoryData>,
    val ingredients: List<IngredientData>,
    val recipe: String,
    val isFavorite: Boolean
)
