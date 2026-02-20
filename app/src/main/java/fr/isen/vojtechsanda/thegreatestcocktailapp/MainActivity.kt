package fr.isen.vojtechsanda.thegreatestcocktailapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.categoriesScreen.CategoriesScreen
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinkDetailScreen.DrinkDetailScreen
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.favoritesScreen.FavoritesScreen
import fr.isen.vojtechsanda.thegreatestcocktailapp.ui.theme.TheGreatestCocktailAppTheme


enum class AppMainActivityScreen() {
    RANDOM,
    LIST,
    FAVORITES;
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            TheGreatestCocktailAppTheme {
                NavHost(
                    navController = navController,
                    startDestination = AppMainActivityScreen.LIST.name
                ) {
                    composable(AppMainActivityScreen.RANDOM.name) {
                        DrinkDetailScreen()
                    }
                    composable(AppMainActivityScreen.LIST.name) {
                        CategoriesScreen()
                    }
                    composable(AppMainActivityScreen.FAVORITES.name) {
                        FavoritesScreen()
                    }
                }
            }
        }
    }
}
