package com.erick.apppasteleria.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import com.erick.apppasteleria.ui.screens.FavoritosScreen
import com.erick.apppasteleria.ui.screens.HomeScreen
import com.erick.apppasteleria.ui.screens.Perfil

sealed class Destinations(
    val route: String
) {



}

sealed class Destinations2(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Login : Destinations2("login", "Login", Icons.Filled.Face)
    object ScreenPrincipal : Destinations2("prin", "Principal", Icons.Filled.Menu)
    object Home : Destinations2("home", "Home", Icons.Filled.Home)
    object Favorito : Destinations2("favorito", "Favoritos", Icons.Filled.Favorite)
    object Perfil : Destinations2("perfil", "Perfil", Icons.Filled.AccountCircle)
    object Maps : Destinations2("maps", "Maps", Icons.Filled.LocationOn)
    object Prueba : Destinations2("prueba", "Prueba", Icons.Filled.LocationOn)

}



typealias MiFuncion = @Composable (NavHostController) -> Unit
sealed class Tabs_items(
    val icon: ImageVector,
    val title: String,
    var screen: MiFuncion,

) {
    object Home_item : Tabs_items(Icons.Filled.Home, "Home" , { navController ->
        HomeScreen(navController = navController, navegarMapsScreen = { navController.navigate(Destinations2.Maps.route)})
    })
    object Favorito_item : Tabs_items(Icons.Filled.Favorite,"Favorito", { FavoritosScreen() } )
    object Perfil_item : Tabs_items(Icons.Filled.AccountCircle,"Perfil", { Perfil() } )

}

