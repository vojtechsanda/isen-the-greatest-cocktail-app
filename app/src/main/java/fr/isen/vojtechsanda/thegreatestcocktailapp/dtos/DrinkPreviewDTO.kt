package fr.isen.vojtechsanda.thegreatestcocktailapp.dtos

import com.google.gson.annotations.SerializedName
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.DrinkPreviewData

data class DrinkPreviewDTO(
    @SerializedName("idDrink")
    val idDrink: String,
    @SerializedName("strDrink")
    val strDrink: String, // Name of the drink
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String?,  // URL to image
)

fun DrinkPreviewDTO.toDrinkPreviewData(): DrinkPreviewData {
    return DrinkPreviewData(
        id = this.idDrink,
        name = this.strDrink,
        imageUrl = this.strDrinkThumb
    )
}
