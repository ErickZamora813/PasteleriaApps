package com.erick.apppasteleria.data.di

import com.erick.apppasteleria.data.Paths
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface AppPasteleriaClient {
    @GET(Paths.ACADEMY)
    fun listPastelesClient(): Call<ResponseBody>
}