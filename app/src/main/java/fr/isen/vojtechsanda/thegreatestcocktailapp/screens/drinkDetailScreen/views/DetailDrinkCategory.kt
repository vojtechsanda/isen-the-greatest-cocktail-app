package fr.isen.vojtechsanda.thegreatestcocktailapp.screens.drinkDetailScreen.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.thegreatestcocktailapp.models.CategoryData

@Composable
fun DrinkDetailCategoryView(category: CategoryData) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier
            .clip(RoundedCornerShape(40.dp))
            .border(
                width = 2.dp,
                color = category.backgroundFrom,
                shape = RoundedCornerShape(40.dp)
            )
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        category.backgroundFrom,
                        category.backgroundTo
                    )
                )
            )
            .padding(vertical = 8.dp, horizontal = 12.dp)
    ) {
        Icon(
            imageVector = category.iconVector,
            contentDescription = "",
            tint = category.textColor
        )

        Text(category.text, color = category.textColor)
    }
}
