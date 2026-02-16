import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import fr.isen.vojtechsanda.thegreatestcocktailapp.R

@Composable
fun InfoCardText(text: String) {
    Text(text = text, fontSize = 20.sp, color = colorResource(R.color.text_gray))
}
