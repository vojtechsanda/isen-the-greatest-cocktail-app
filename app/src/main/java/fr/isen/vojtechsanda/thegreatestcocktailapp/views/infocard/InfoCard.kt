import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.vojtechsanda.thegreatestcocktailapp.R

@Composable
fun InfoCardView(title: String, titleIconVector: ImageVector, content: @Composable () -> Unit) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .border(
                color = colorResource(R.color.super_light_purple),
                width = 2.dp,
                shape = RoundedCornerShape(20.dp)
            )
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        colorResource(R.color.super_light_purple),
                        colorResource(R.color.light_purple)
                    )
                )
            )
            .padding(all = 20.dp)
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = titleIconVector,
                contentDescription = ""

            )

            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        content()
    }
}
