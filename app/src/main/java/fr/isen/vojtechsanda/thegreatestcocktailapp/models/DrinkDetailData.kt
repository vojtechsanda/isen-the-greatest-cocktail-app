package fr.isen.vojtechsanda.thegreatestcocktailapp.models

data class DrinkDetailData(
    val id: String,
    val imageUrl: String?,
    val name: String,
    val categories: List<CategoryData>,
    val ingredients: List<IngredientData>,
    val recipe: String?,
    val isFavorite: Boolean
)
