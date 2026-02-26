package fr.isen.vojtechsanda.thegreatestcocktailapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinksScreen.DrinksScreen
import fr.isen.vojtechsanda.thegreatestcocktailapp.ui.theme.TheGreatestCocktailAppTheme

class DrinksActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val categoryId = intent.getStringExtra(EXTRA_CATEGORY_ID) ?: ""

        setContent {
            TheGreatestCocktailAppTheme {
                DrinksScreen(categoryId)
            }
        }
    }

    companion object {
        const val EXTRA_CATEGORY_ID = "CATEGORY_ID"
    }
}
