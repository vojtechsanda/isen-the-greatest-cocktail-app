package fr.isen.vojtechsanda.thegreatestcocktailapp.dtos

import com.google.gson.annotations.SerializedName
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.CategoryPreviewData

data class CategoryPreviewDTO(
    @SerializedName("strCategory")
    val strCategory: String
)

fun CategoryPreviewDTO.toCategoryPreviewData(): CategoryPreviewData {
    return CategoryPreviewData(
        id = this.strCategory,
        name = this.strCategory,
    )
}
