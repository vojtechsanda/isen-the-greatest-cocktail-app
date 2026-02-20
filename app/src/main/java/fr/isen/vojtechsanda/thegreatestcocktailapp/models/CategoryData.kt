package fr.isen.vojtechsanda.thegreatestcocktailapp.models

import androidx.annotation.ColorRes
import androidx.compose.ui.graphics.vector.ImageVector
import fr.isen.vojtechsanda.thegreatestcocktailapp.R

data class CategoryData(
    val id: String,
    val name: String,
    val iconVector: ImageVector,
    @ColorRes val backgroundFromRes: Int,
    @ColorRes val backgroundToRes: Int,
    @ColorRes val textColorRes: Int = R.color.white,
)
