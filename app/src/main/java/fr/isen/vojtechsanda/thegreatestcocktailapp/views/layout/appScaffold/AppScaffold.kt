package fr.isen.vojtechsanda.thegreatestcocktailapp.views.layout.appScaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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

@Composable
fun AppScaffold(
    topBar: @Composable (() -> Unit) = {},
    content: @Composable (modifier: Modifier) -> Unit,
    verticalScrolling: Boolean = false,
    withBottomBar: Boolean = false
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = topBar,
    ) { scaffoldInnerPadding ->
        val scrollingModifier =
            if (verticalScrolling) Modifier.verticalScroll(rememberScrollState()) else Modifier;

        val paddingModifier =
            if (withBottomBar) Modifier.padding(top = scaffoldInnerPadding.calculateTopPadding()) else Modifier.padding(
                top = scaffoldInnerPadding.calculateTopPadding(),
                bottom = scaffoldInnerPadding.calculateBottomPadding() + 8.dp
            )

        Box(
            modifier = paddingModifier
                .then(scrollingModifier)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            colorResource(R.color.deep_midnight_purple),
                            colorResource(R.color.near_black_plum)
                        )
                    )
                )
                .fillMaxHeight()
        ) {
            content(
                Modifier.fillMaxWidth()
            )
        }
    }
}
