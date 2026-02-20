package fr.isen.vojtechsanda.thegreatestcocktailapp.dtos

import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    @SerializedName("drinks")
    val drinks: List<CategoryDTO>
)

data class DrinksListResponse(
    @SerializedName("drinks")
    val drinks: List<DrinkPreviewDTO>
)

data class DrinkDetailResponse(
    @SerializedName("drinks")
    val drinks: List<DrinkDetailDTO>
)

data class RandomDrinkResponse(
    @SerializedName("drinks")
    val drinks: List<DrinkDetailDTO>
)
