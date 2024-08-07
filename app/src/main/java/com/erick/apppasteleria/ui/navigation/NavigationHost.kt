package com.erick.apppasteleria.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.erick.apppasteleria.ScreenPrincipal
import com.erick.apppasteleria.ui.navigation.Destinations2.*
import com.erick.apppasteleria.ui.screens.FavoritosScreen
import com.erick.apppasteleria.ui.screens.HomeScreen
import com.erick.apppasteleria.ui.screens.LoginScreen
import com.erick.apppasteleria.ui.screens.MapsScreen
import com.erick.apppasteleria.ui.screens.Perfil
import com.erick.apppasteleria.ui.screens.ScreenPrueba

@Composable
fun NavigationHost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Login.route) {
        composable(Login.route) {
            LoginScreen(navController = navController)

        }

        composable(ScreenPrincipal.route){
            ScreenPrincipal(navController)
        }

        composable(Home.route) {
                HomeScreen(
                    navController = navController,
                    navegarMapsScreen = { navController.navigate(Maps.route) }
                )
            }
        composable(Favorito.route) {
                FavoritosScreen()
            }
        composable(Perfil.route) {
                Perfil()
            }
        composable(Maps.route) {
                MapsScreen()
            }
        composable(Prueba.route) {
                ScreenPrueba()
            }




    }


}
