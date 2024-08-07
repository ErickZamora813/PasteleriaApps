package com.erick.apppasteleria.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.erick.apppasteleria.ui.components.BoxPerfil
import com.erick.apppasteleria.ui.theme.PinkPasteleria

@Composable
fun Perfil(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PinkPasteleria),

    ) {
        BoxPerfil()

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFunciond(){
    Perfil()
}