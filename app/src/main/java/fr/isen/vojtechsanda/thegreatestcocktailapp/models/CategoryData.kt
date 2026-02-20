package fr.isen.vojtechsanda.thegreatestcocktailapp.models

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class CategoryData(
    val id: String,
    val text: String,
    val iconVector: ImageVector,
    val backgroundFrom: Color,
    val backgroundTo: Color,
    val textColor: Color = Color.White
)
