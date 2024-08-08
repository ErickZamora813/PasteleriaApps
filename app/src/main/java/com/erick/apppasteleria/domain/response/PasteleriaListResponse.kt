package com.erick.apppasteleria.domain.response

import com.erick.apppasteleria.domain.listeners.Pasteles

data class PasteleriaListResponse (
    val SUCCES: Int,
    val DATA: List<Pasteles>
)