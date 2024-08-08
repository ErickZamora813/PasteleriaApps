package com.erick.apppasteleria.domain.listeners

interface PastelesListener {
    fun onSucces(pastelesList: List<Pasteles>)
    fun onError(error: String)
}