package com.erick.apppasteleria.ui.screens

//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.erick.apppasteleria.ScreenPrincipal
import com.erick.apppasteleria.ui.navigation.Destinations2
import com.erick.apppasteleria.ui.viewmodels.LoginViewModel
import com.erick.apppasteleria.ui.viewmodels.UserViewModel
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = viewModel()) {
    val showLoginForm = rememberSaveable {
        mutableStateOf(true)
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (showLoginForm.value) {
                Text(text = "Inicia Sesión")
                UserForm(
                    isCreateAccount = false
                ) { email, password ->
                    viewModel.singInWithEmailAndPassword(email, password){
                        navController.navigate(Destinations2.ScreenPrincipal.route){
                            popUpTo(Destinations2.Login.route){ inclusive = true}
                        }
                    }
                }
            } else {
                Text(text = "Crear una cuenta")
                UserForm(
                    isCreateAccount = true

                ) { email, password ->
                    viewModel.createUserWithEmailAndPassword(email, password){
                        navController.navigate(Destinations2.ScreenPrincipal.route){
                            popUpTo(Destinations2.Login.route){ inclusive = true}
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val text1 =
                    if (showLoginForm.value) "¿No tienes una cuenta?"
                    else "¿Ya tienes una cuenta?"
                val text2 =
                    if (showLoginForm.value) "Resgitrarse"
                    else "Iniciar sesión"
                Text(text = text1)
                Text(text = text2, modifier = Modifier
                    .clickable { showLoginForm.value = !showLoginForm.value }
                    .padding(5.dp),
                )
            }
        }

    }
}

@Composable
fun UserForm(
    isCreateAccount: Boolean = false,
    onDone: (String, String) -> Unit = { email, pwd -> }
) {
    val email = rememberSaveable {
        mutableStateOf("")
    }
    val password = rememberSaveable {
        mutableStateOf("")
    }
    val passwordVisible = rememberSaveable {
        mutableStateOf(false)
    }
    val valido = remember(email.value, password.value) {
        email.value.trim().isNotEmpty() &&
                password.value.trim().isNotEmpty()
    }
    val keyborardController = LocalSoftwareKeyboardController.current
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        EmailInput(
            emailState = email
        )
        PasswordInput(
            passwordState = password,
            labelId = "Password",
            passwordVisible = passwordVisible
        )
        SubmitButton(
            textId = if (isCreateAccount) "Crear cuenta" else "Login",
            inputValido = valido
        ) {
            onDone(email.value.trim(), password.value.trim())
            keyborardController?.hide()
        }
    }


}

@Composable
fun SubmitButton(textId: String, inputValido: Boolean, onClic: () -> Unit) {
    Button(
        onClick = onClic,
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        shape = CircleShape,
        enabled = inputValido
    ) {
        Text(text = textId, modifier = Modifier.padding(5.dp))

    }
}

@Composable
fun PasswordInput(
    passwordState: MutableState<String>,
    labelId: String,
    passwordVisible: MutableState<Boolean>
) {
    val visualTransformation = if (passwordVisible.value)
        VisualTransformation.None
    else PasswordVisualTransformation()


    OutlinedTextField(
        value = passwordState.value,
        onValueChange = { passwordState.value = it },
        label = { Text(text = labelId) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        visualTransformation = visualTransformation,
        trailingIcon = {
            if (passwordState.value.isNotBlank()) {
                PasswordVisibleIcon(passwordVisible)
            } else null
        }
    )
}

@Composable
fun PasswordVisibleIcon(passwordVisible: MutableState<Boolean>) {
    val image =
        if (passwordVisible.value)
            Icons.Default.VisibilityOff
        else
            Icons.Default.Visibility

    IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
        Icon(imageVector = image, contentDescription = "")
    }

}

@Composable
fun EmailInput(emailState: MutableState<String>, labelId: String = "Email") {
    InputField(
        valueState = emailState,
        labelId = labelId,
        keyboardType = KeyboardType.Email
    )

}

@Composable
fun InputField(
    valueState: MutableState<String>,
    labelId: String,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType
) {
    OutlinedTextField(
        value = valueState.value,
        onValueChange = { valueState.value = it },
        label = { Text(text = labelId) },
        singleLine = isSingleLine,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )

}
