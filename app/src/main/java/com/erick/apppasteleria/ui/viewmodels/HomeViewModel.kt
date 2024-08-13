package com.erick.apppasteleria.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erick.apppasteleria.domain.listeners.Pasteles
import com.erick.apppasteleria.domain.listeners.PastelesListener
import com.erick.apppasteleria.domain.useCase.PastelesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: PastelesUseCase
) : ViewModel() {

    private val _pastelesList = MutableLiveData<List<Pasteles>>()
    val pastelesList : LiveData<List<Pasteles>> = _pastelesList

    fun getPastelesApp(){
        pastelesPasteleria()
    }

    private fun pastelesPasteleria(){
        viewModelScope.launch {
            useCase.invokePastelesList(
                object : PastelesListener {
                    override fun onSucces(pastelesList: List<Pasteles>) {
                        _pastelesList.value = pastelesList
                    }

                    override fun onError(error: String) {
                        Log.d("error en la api", error)
                    }

                }
            )
        }
    }
}


