package com.erick.apppasteleria.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.erick.apppasteleria.ui.components.NavigationBar

@Composable
fun MainScreen(navController: NavController){

    Scaffold (
        topBar = {
            //NavigationBar(navController)
        },
        content = { paddingValues ->
            Box (modifier = Modifier.padding(paddingValues)){

            }

        }
    )

}