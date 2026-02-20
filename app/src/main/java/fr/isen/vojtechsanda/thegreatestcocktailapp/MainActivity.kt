package fr.isen.vojtechsanda.thegreatestcocktailapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Scaffold
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.categoriesScreen.CategoriesScreen
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinkDetailScreen.DrinkDetailScreen
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.favoritesScreen.FavoritesScreen
import fr.isen.vojtechsanda.thegreatestcocktailapp.ui.theme.TheGreatestCocktailAppTheme
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.layout.bottomNavigationBar.BottomNavigationBar
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.layout.bottomNavigationBar.BottomNavigationBarItem

enum class AppBottomNavigation(val description: String) {
    RANDOM("Random"),
    LIST("List"),
    FAVORITES("Favorites");

    override fun toString(): String {
        return description
    }
}

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            val categoryItem = BottomNavigationBarItem(
                id = AppBottomNavigation.LIST.name,
                stringResource(R.string.tab_item_category),
                Icons.Filled.Menu,
            )
            val randomItem = BottomNavigationBarItem(
                id = AppBottomNavigation.RANDOM.name,
                stringResource(R.string.tab_item_random),
                Icons.Filled.Home,
            )
            val favoriteItem = BottomNavigationBarItem(
                id = AppBottomNavigation.FAVORITES.name,
                stringResource(R.string.tab_item_favorite),
                Icons.Filled.Favorite,
            )

            val items = listOf(randomItem, categoryItem, favoriteItem)

            TheGreatestCocktailAppTheme {
                Scaffold(
                    bottomBar = { BottomNavigationBar(navController, items) }
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = AppBottomNavigation.LIST.name
                    ) {
                        composable(AppBottomNavigation.RANDOM.name) {
                            DrinkDetailScreen()
                        }
                        composable(AppBottomNavigation.LIST.name) {
                            CategoriesScreen()
                        }
                        composable(AppBottomNavigation.FAVORITES.name) {
                            FavoritesScreen()
                        }
                    }
                }
            }
        }
    }
}
