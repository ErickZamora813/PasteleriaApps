package com.erick.apppasteleria

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.erick.apppasteleria.ui.components.NavigationBar
import com.erick.apppasteleria.ui.components.TopMenu
import com.erick.apppasteleria.ui.navigation.Destinations2.*
import com.erick.apppasteleria.ui.navigation.NavigationHost
import com.erick.apppasteleria.ui.theme.AppPasteleriaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val db = AppDatabase.getDatabase(this)
        //enableEdgeToEdge()
        setContent {
            AppPasteleriaTheme {
                val navController = rememberNavController()
                NavigationHost(navController)
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScreenPrincipal(navController: NavHostController){
    val navigationItems = listOf(
        Home,
        Favorito,
        Perfil
    )
    Scaffold(topBar = {
        //TopMenu(navController)
        //NavigationBar(navController = navController, items = navigationItems)
    }){
        TopMenu(navController)
        //NavigationHost(navController)
    }
}
