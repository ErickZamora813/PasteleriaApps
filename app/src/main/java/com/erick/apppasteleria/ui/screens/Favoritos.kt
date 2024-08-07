package com.erick.apppasteleria.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.erick.apppasteleria.ui.components.HeaderFavoritos
import com.erick.apppasteleria.ui.components.TextoImage
import com.erick.apppasteleria.ui.theme.PinkPasteleria

@Composable
fun FavoritosScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .background(PinkPasteleria),

    ) {
        Column {
            HeaderFavoritos()
            TextoImage()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewFuncionxd(){
    FavoritosScreen()
}