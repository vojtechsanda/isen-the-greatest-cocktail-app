package fr.isen.vojtechsanda.thegreatestcocktailapp.screens.detailDrinkScreen.views

import android.widget.Toast
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.thegreatestcocktailapp.R
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.DrinkData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailDrinkTopAppBar(cocktail: DrinkData) {
    val context = LocalContext.current

    TopAppBar(
        title = {
            Text("${stringResource(R.string.cocktail)} ${cocktail.name}")
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(R.color.deep_midnight_purple),
            titleContentColor = colorResource(R.color.white),
        ),
        actions = {
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    if (cocktail.isFavorite) "Remove from favorites | TMP" else "Add to favorites | TMP",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Icon(
                    tint = colorResource(R.color.red),
                    modifier = Modifier.size(32.dp),
                    imageVector = if (cocktail.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = if (cocktail.isFavorite) stringResource(R.string.add_to_favorites) else stringResource(
                        R.string.remove_from_favorites
                    )
                )
            }
        }
    )
}
