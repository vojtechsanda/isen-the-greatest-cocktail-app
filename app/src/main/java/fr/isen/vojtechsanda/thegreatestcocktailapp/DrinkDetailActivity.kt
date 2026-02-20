package fr.isen.vojtechsanda.thegreatestcocktailapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinkDetailScreen.DrinkDetailScreen
import fr.isen.vojtechsanda.thegreatestcocktailapp.ui.theme.TheGreatestCocktailAppTheme

class DrinkDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val drinkId = intent.getStringExtra("DRINK_ID") ?: ""

        setContent {
            TheGreatestCocktailAppTheme {
                DrinkDetailScreen(drinkId)
            }
        }
    }
}
