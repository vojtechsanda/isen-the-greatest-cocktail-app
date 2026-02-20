package fr.isen.vojtechsanda.thegreatestcocktailapp.storage

import android.content.Context
import androidx.core.content.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class FavoritesSharedPreferencesManager {
    private val sharedPreferencesKey = "theGreatestCocktailApp"
    private val favoritesPreferencesKey = "favoriteDrinks"

    fun getFavoriteDrinksFlow(context: Context): Flow<Set<String>> {
        val sharedPref =
            context.getSharedPreferences(sharedPreferencesKey, Context.MODE_PRIVATE)

        return sharedPref
            .getStringSetFlow(favoritesPreferencesKey, setOf())
    }

    suspend fun toggleFavoriteDrink(context: Context, drinkId: String) {
        val sharedPref =
            context.getSharedPreferences(sharedPreferencesKey, Context.MODE_PRIVATE)

        val favoriteDrinksIds = getFavoriteDrinksFlow(context).first()
        val isFavorite = favoriteDrinksIds.contains(drinkId)

        val newFavoriteDrinksIds = if (isFavorite) {
            favoriteDrinksIds.minus(drinkId)
        } else {
            favoriteDrinksIds.plus(drinkId)
        }

        sharedPref.edit(commit = true) {
            putStringSet(
                favoritesPreferencesKey,
                newFavoriteDrinksIds
            )
        }
    }
}

// TODO: Přidat do activity static konstantu pro prop name
