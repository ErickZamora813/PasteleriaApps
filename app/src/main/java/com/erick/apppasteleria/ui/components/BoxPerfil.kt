package com.erick.apppasteleria.ui.components

import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextButton
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.erick.apppasteleria.R

@Composable
fun BoxPerfil(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val imageUri = remember {
        mutableStateOf<Uri?>(null)
    }
    val bitmap = remember {
        mutableStateOf<Bitmap?>(null)
    }

    val launcherCamera =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.TakePicturePreview()) { capturedImage ->
            if (capturedImage != null) {
                bitmap.value = capturedImage
            }
        }

    val launcherGalllery =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri ->
            imageUri.value = uri

        }
    val showDialog = remember { mutableStateOf(false) }

    Card(
        modifier.padding(20.dp),
        border = BorderStroke(
            1.dp,
            Color.Black
        )
    )
    {
        Column(
            modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Row {

                Box(
                    modifier = Modifier
                        .padding(20.dp)
                        .width(100.dp)
                        .height(100.dp)
                        .clickable { showDialog.value = true }
                ) {
                    imageUri.value?.let {
                        Image(
                            painter = rememberAsyncImagePainter(model = it),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    } ?: bitmap.value?.let {
                        Image(
                            bitmap = it.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    } ?: Image(
                        painter = painterResource(id = R.drawable.pngegg),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }

//                Column(modifier.padding(10.dp)) {
//                    Text(text = "Nombre de usuario", modifier.padding(5.dp))
//                    Text(text = "Email", modifier.padding(5.dp))
//                    Text(text = "Phone", modifier.padding(5.dp))
//                    Text(text = "Address", modifier.padding(5.dp))
//                }
            }

            Spacer(modifier = modifier.height(20.dp))

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(10.dp),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Button(onClick = { launcherCamera.launch(null) }) {
//                    Text(text = "Usar Cámara")
//                }
//                Button(onClick = { launcherGalllery.launch("image/*") }) {
//                    Text(text = "Abrir Galería")
//                }
//            }

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

            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier
                    .padding(20.dp)
                    .align(Alignment.End)
            ) {
                Text("Actualizar ")

            }
        }
    }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = "Cambiar imagen de perfil") },
            text = { Text("Elige una opción") },
            confirmButton = {
                TextButton(onClick = {
                    showDialog.value = false
                    launcherCamera.launch(null)
                }) {
                    Text("Usar Cámara")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showDialog.value = false
                    launcherGalllery.launch("image/*")
                }) {
                    Text("Abrir Galería")
                }
            }
        )
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewFunciond() {
    BoxPerfil()
}