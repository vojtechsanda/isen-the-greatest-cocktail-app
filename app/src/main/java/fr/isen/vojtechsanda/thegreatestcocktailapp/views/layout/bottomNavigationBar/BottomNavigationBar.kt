package fr.isen.vojtechsanda.thegreatestcocktailapp.views.layout.bottomNavigationBar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

data class BottomNavigationBarItem(
    val id: String,
    val title: String,
    val icon: ImageVector,
)

@Composable
fun BottomNavigationBar(navController: NavController, items: List<BottomNavigationBarItem>) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.id,
                onClick = {
                    navController.navigate(item.id)
                },
                icon = {
                    Icon(
                        item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) })
        }
    }
}
