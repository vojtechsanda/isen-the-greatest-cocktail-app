import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.thegreatestcocktailapp.R
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.CocktailData

@Composable
fun CocktailScaffold(cocktail: CocktailData, content: @Composable (modifier: Modifier) -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { DetailCocktailTopAppBar(cocktail) }
    ) { scaffoldInnerPadding ->
        Box(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            colorResource(R.color.deep_midnight_purple),
                            colorResource(R.color.near_black_plum)
                        )
                    )
                )
                .padding(scaffoldInnerPadding)
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
        ) {
            content(Modifier.padding(all = 20.dp))
        }
    }
}
