package com.erick.apppasteleria.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.erick.apppasteleria.R
import com.erick.apppasteleria.ui.components.IconosPasteles
import com.erick.apppasteleria.ui.components.SliderImage
import com.erick.apppasteleria.ui.theme.BordesImage
import com.erick.apppasteleria.ui.theme.PinkPasteleria

@Composable
fun HomeScreen(
//    homeViewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController,
    navegarMapsScreen: () -> Unit
) {

//    LaunchedEffect (true){
//        homeViewModel.pastelesList
//
//    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .background(PinkPasteleria)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Contenido principal de la pantalla
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.weight(1f)
            ) {
                SliderImage()
                Spacer(modifier = Modifier.height(25.dp))
                IconosPasteles()
                Spacer(modifier = Modifier.height(40.dp))
                SliderImage()
            }

            // Pie de página con el botón
            Box {
                OutlinedButton(
                    onClick = { navegarMapsScreen() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    border = BorderStroke(1.dp, BordesImage)
                ) {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.maps2),
                            contentDescription = null,
                            modifier = Modifier.size(35.dp),
                            contentScale = ContentScale.Crop
                        )
                        Text(text = "Ven y Visitanos ", modifier = Modifier.padding(5.dp))
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewFuncion(){
//    HomeScreen()
//}

