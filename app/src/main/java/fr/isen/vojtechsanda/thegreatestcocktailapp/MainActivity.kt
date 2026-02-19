package fr.isen.vojtechsanda.thegreatestcocktailapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.categoriesScreen.CategoriesScreen
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinksScreen.DrinksScreen
import fr.isen.vojtechsanda.thegreatestcocktailapp.ui.theme.TheGreatestCocktailAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheGreatestCocktailAppTheme {
                DrinksScreen()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TheGreatestCocktailAppTheme {
        CategoriesScreen()
    }
}
