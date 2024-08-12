package com.erick.apppasteleria.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erick.apppasteleria.ui.screens.HomeScreen
import com.erick.apppasteleria.ui.screens.ScreenPrueba
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)

    fun singInWithEmailAndPassword(email: String, password: String, onSucces: () -> Unit) =
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d("Hola", "Se ha ingresado de manera correcta")
                            onSucces()
                        } else {
                            Log.d("Hola", "Ha ocurrido algo ${task.result}")
                        }

                    }
            } catch (ex: Exception) {
                Log.d("Hola", "No se que ha pasado ${ex.message}")
            }
        }

    fun createUserWithEmailAndPassword(email: String, password: String, onSucces: () -> Unit) {
        if (_loading.value == false){
            _loading.value = true
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {task ->
                    if (task.isSuccessful){

                    }
                    else{
                        Log.d("Hola", "Ha ocurrido un error en el registro: ${task.result.toString()}")
                    }
                    _loading.value = false

                }

        }

    }
}