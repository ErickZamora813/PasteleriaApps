package com.erick.apppasteleria.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun NavigationBar1(navController: NavController) {
    BottomNavigation() {
        BottomNavigationItem(
            selected = false,
            label = { Text("Home") },
            onClick = {
                navController.navigate("home") {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") })

        BottomNavigationItem(
            selected = false,
            label = { Text("Favoritos") },
            onClick = {
                navController.navigate("favoritos") {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = { Icon(Icons.Default.Favorite, contentDescription = "Favoritos") })

        BottomNavigationItem(
            selected = false,
            label = { Text("Perfil") },
            onClick = {
                navController.navigate("perfil") {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = { Icon(Icons.Default.Home, contentDescription = "Perfil") })
    }

}