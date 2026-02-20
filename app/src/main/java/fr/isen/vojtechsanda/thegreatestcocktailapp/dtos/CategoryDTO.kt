package fr.isen.vojtechsanda.thegreatestcocktailapp.dtos

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import com.google.gson.annotations.SerializedName
import fr.isen.vojtechsanda.thegreatestcocktailapp.R
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.CategoryData

data class CategoryDTO(
    @SerializedName("strCategory")
    val strCategory: String
)

fun CategoryDTO.toCategoryData(): CategoryData {
    return CategoryData(
        id = this.strCategory,
        name = this.strCategory,
        iconVector = Icons.Default.Info,
        backgroundFromRes = R.color.light_blue,
        backgroundToRes = R.color.dark_blue
    )
}
