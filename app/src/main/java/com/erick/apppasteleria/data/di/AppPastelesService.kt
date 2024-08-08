package com.erick.apppasteleria.data.di

import com.erick.apppasteleria.domain.listeners.PastelesListener
import com.google.gson.Gson
import javax.inject.Inject

class AppPastelesService @Inject constructor(
    private val apiService:AppPasteleriaClient,
    private val gson:Gson
) {

    fun listColeccionPasteles(listener:PastelesListener){


    }
}