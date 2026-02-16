package fr.isen.vojtechsanda.thegreatestcocktailapp.models

enum class IngredientUnitEnum(val description: String) {
    CUP("cup"),
    PIECE("piece");

    override fun toString(): String {
        return description
    }
}
