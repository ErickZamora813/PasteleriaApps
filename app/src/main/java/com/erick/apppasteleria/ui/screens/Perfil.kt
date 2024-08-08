package com.erick.apppasteleria.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.erick.apppasteleria.data.analytics.AnalyticsEvent
import com.erick.apppasteleria.data.analytics.LogAnalyticsEvent
import com.erick.apppasteleria.ui.components.BoxPerfil
import com.erick.apppasteleria.ui.theme.PinkPasteleria

@Composable
fun Perfil(){

    val context = LocalContext.current
    LaunchedEffect (Unit){
        LogAnalyticsEvent(context, AnalyticsEvent.ScrennViewProfile)
    }

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