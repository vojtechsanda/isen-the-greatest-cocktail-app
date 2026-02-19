package fr.isen.vojtechsanda.thegreatestcocktailapp.views.columnItemCard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.vojtechsanda.thegreatestcocktailapp.views.appCard.AppCard

@Composable
fun ColumnItemCardView(title: String, leading: @Composable () -> Unit) {
    AppCard() {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            leading()

            Text(title, fontSize = 20.sp)
        }
    }
}
