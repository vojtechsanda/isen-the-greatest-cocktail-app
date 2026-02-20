package fr.isen.vojtechsanda.thegreatestcocktailapp.dtos

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import com.google.gson.annotations.SerializedName
import fr.isen.vojtechsanda.thegreatestcocktailapp.R
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.CategoryData
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.DrinkDetailData
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.IngredientData

data class DrinkDetailDTO(
    @SerializedName("idDrink")
    val idDrink: String,
    @SerializedName("strDrink")
    val strDrink: String,
    @SerializedName("strDrinkAlternate")
    val strDrinkAlternate: String?,
    @SerializedName("strTags")
    val strTags: String?,
    @SerializedName("strVideo")
    val strVideo: String?,
    @SerializedName("strCategory")
    val strCategory: String?,
    @SerializedName("strIBA")
    val strIBA: String?,
    @SerializedName("strAlcoholic")
    val strAlcoholic: String?,
    @SerializedName("strGlass")
    val strGlass: String?,
    @SerializedName("strInstructions")
    val strInstructions: String?,
    @SerializedName("strInstructionsES")
    val strInstructionsES: String?,
    @SerializedName("strInstructionsDE")
    val strInstructionsDE: String?,
    @SerializedName("strInstructionsFR")
    val strInstructionsFR: String?,
    @SerializedName("strInstructionsIT")
    val strInstructionsIT: String?,
    @SerializedName("strInstructionsZH-HANS")
    val `strInstructionsZH-HANS`: String?,
    @SerializedName("strInstructionsZH-HANT")
    val `strInstructionsZH-HANT`: String?,
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String?,
    @SerializedName("strIngredient1")
    val strIngredient1: String?,
    @SerializedName("strIngredient2")
    val strIngredient2: String?,
    @SerializedName("strIngredient3")
    val strIngredient3: String?,
    @SerializedName("strIngredient4")
    val strIngredient4: String?,
    @SerializedName("strIngredient5")
    val strIngredient5: String?,
    @SerializedName("strIngredient6")
    val strIngredient6: String?,
    @SerializedName("strIngredient7")
    val strIngredient7: String?,
    @SerializedName("strIngredient8")
    val strIngredient8: String?,
    @SerializedName("strIngredient9")
    val strIngredient9: String?,
    @SerializedName("strIngredient10")
    val strIngredient10: String?,
    @SerializedName("strIngredient11")
    val strIngredient11: String?,
    @SerializedName("strIngredient12")
    val strIngredient12: String?,
    @SerializedName("strIngredient13")
    val strIngredient13: String?,
    @SerializedName("strIngredient14")
    val strIngredient14: String?,
    @SerializedName("strIngredient15")
    val strIngredient15: String?,
    @SerializedName("strMeasure1")
    val strMeasure1: String?,
    @SerializedName("strMeasure2")
    val strMeasure2: String?,
    @SerializedName("strMeasure3")
    val strMeasure3: String?,
    @SerializedName("strMeasure4")
    val strMeasure4: String?,
    @SerializedName("strMeasure5")
    val strMeasure5: String?,
    @SerializedName("strMeasure6")
    val strMeasure6: String?,
    @SerializedName("strMeasure7")
    val strMeasure7: String?,
    @SerializedName("strMeasure8")
    val strMeasure8: String?,
    @SerializedName("strMeasure9")
    val strMeasure9: String?,
    @SerializedName("strMeasure10")
    val strMeasure10: String?,
    @SerializedName("strMeasure11")
    val strMeasure11: String?,
    @SerializedName("strMeasure12")
    val strMeasure12: String?,
    @SerializedName("strMeasure13")
    val strMeasure13: String?,
    @SerializedName("strMeasure14")
    val strMeasure14: String?,
    @SerializedName("strMeasure15")
    val strMeasure15: String?,
    @SerializedName("strImageSource")
    val strImageSource: String?,
    @SerializedName("strImageAttribution")
    val strImageAttribution: String?,
    @SerializedName("strCreativeCommonsConfirmed")
    val strCreativeCommonsConfirmed: String?,
    @SerializedName("dateModified")
    val dateModified: String?
)

fun DrinkDetailDTO.toDrinkDetailData(): DrinkDetailData {
    val ingredients = listOf(
        if (this.strIngredient1 != null) IngredientData(
            this.strIngredient1,
            this.strMeasure1,
        ) else null,

        if (this.strIngredient2 != null) IngredientData(
            this.strIngredient2,
            this.strMeasure2,
        ) else null,

        if (this.strIngredient3 != null) IngredientData(
            this.strIngredient3,
            this.strMeasure3,
        ) else null,

        if (this.strIngredient4 != null) IngredientData(
            this.strIngredient4,
            this.strMeasure4,
        ) else null,

        if (this.strIngredient5 != null) IngredientData(
            this.strIngredient5,
            this.strMeasure5,
        ) else null,

        if (this.strIngredient6 != null) IngredientData(
            this.strIngredient6,
            this.strMeasure6,
        ) else null,

        if (this.strIngredient7 != null) IngredientData(
            this.strIngredient7,
            this.strMeasure7,
        ) else null,

        if (this.strIngredient8 != null) IngredientData(
            this.strIngredient8,
            this.strMeasure8,
        ) else null,

        if (this.strIngredient9 != null) IngredientData(
            this.strIngredient9,
            this.strMeasure9,
        ) else null,

        if (this.strIngredient10 != null) IngredientData(
            this.strIngredient10,
            this.strMeasure10,
        ) else null,

        if (this.strIngredient11 != null) IngredientData(
            this.strIngredient11,
            this.strMeasure11,
        ) else null,

        if (this.strIngredient12 != null) IngredientData(
            this.strIngredient12,
            this.strMeasure12,
        ) else null,

        if (this.strIngredient13 != null) IngredientData(
            this.strIngredient13,
            this.strMeasure13,
        ) else null,

        if (this.strIngredient14 != null) IngredientData(
            this.strIngredient14,
            this.strMeasure14,
        ) else null,

        if (this.strIngredient15 != null) IngredientData(
            this.strIngredient15,
            this.strMeasure15,
        ) else null,
    ).mapNotNull({ it })

    val categories = listOf(
        if (this.strCategory != null)
            CategoryData(
                id = this.strCategory,
                name = this.strCategory,
                iconVector = Icons.Default.Info,
                backgroundFromRes = R.color.light_blue,
                backgroundToRes = R.color.dark_blue
            ) else null,

        if (this.strAlcoholic != null)
            CategoryData(
                id = this.strAlcoholic,
                name = this.strAlcoholic,
                iconVector = Icons.Default.Warning,
                backgroundFromRes = R.color.muted_sage,
                backgroundToRes = R.color.dark_forest_green
            ) else null,

        if (this.strGlass != null)
            CategoryData(
                id = this.strGlass,
                name = this.strGlass,
                iconVector = Icons.Default.Star,
                backgroundFromRes = R.color.transparent,
                backgroundToRes = R.color.transparent,
                textColorRes = R.color.teal_200,
            ) else null
    ).mapNotNull { it }


    return DrinkDetailData(
        id = this.idDrink,
        imageUrl = this.strDrinkThumb,
        name = this.strDrink,
        categories = categories,
        ingredients = ingredients,
        recipe = this.strInstructions
    )
}
