package com.erick.apppasteleria.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erick.apppasteleria.R
import com.erick.apppasteleria.ui.screens.HomeScreen

@Composable
fun HeaderFavoritos(modifier: Modifier = Modifier.fillMaxWidth()) {
    Box(modifier) {
        Image(painter = painterResource(id = R.drawable.rebanada1), contentDescription = null, modifier.fillMaxWidth().height(200.dp), contentScale = ContentScale.Crop)
        Text(text = "Quizás quieras probar también......", modifier.padding(10.dp), fontWeight = FontWeight.Bold )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFuncion(){
    HeaderFavoritos()
}