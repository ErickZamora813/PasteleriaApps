package com.erick.apppasteleria.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erick.apppasteleria.R

@Composable
fun BoxPerfil(modifier: Modifier = Modifier) {
    Card(modifier.padding(20.dp), border = BorderStroke(1.dp, Color.Black)) {
        Column(
            modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.pngegg),
                    contentDescription = null,
                    modifier
                        .padding(20.dp)
                        .width(100.dp)
                )
                Column(modifier.padding(10.dp)) {
                    Text(text = "Nombre de usuario", modifier.padding(5.dp))
                    Text(text = "Email", modifier.padding(5.dp))
                    Text(text = "Phone", modifier.padding(5.dp))
                    Text(text = "Address", modifier.padding(5.dp))
                }
            }

            Spacer(modifier = modifier.height(20.dp))

            Text(text = "Editar Perfil", modifier.padding(15.dp))

            OutlinedTextField(
                value = "Nombre de usuario",
                onValueChange = { },
                modifier
                    .fillMaxWidth()
                    .padding(10.dp)

            )

            OutlinedTextField(
                value = "Email",
                onValueChange = {},
                modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            OutlinedTextField(
                value = "Phone",
                onValueChange = {},
                modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            OutlinedTextField(
                value = "Addres",
                onValueChange = {},
                modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )

            OutlinedButton(onClick = { /*TODO*/ }, modifier.padding(20.dp).align(Alignment.End)) {
                Text("Actualizar ")
                
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFunciond() {
    BoxPerfil()
}