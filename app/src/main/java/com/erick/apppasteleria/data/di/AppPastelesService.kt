package com.erick.apppasteleria.data.di

import com.erick.apppasteleria.domain.listeners.PastelesListener
import com.erick.apppasteleria.domain.response.PasteleriaListResponse
//import com.google.gson.Gson
//import okhttp3.ResponseBody
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import javax.inject.Inject

//class AppPastelesService @Inject constructor(
//    private val apiService: AppPasteleriaClient,
//    private val gson: Gson
//) {
//
//    suspend fun getPasteles(listener: PastelesListener) {
//        val pasteles = apiService.listPastelesClient()
//        pasteles.enqueue(object : Callback<ResponseBody>{
//            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//                val json:String? = response.body()?.string()
//                val pastelesObject: PasteleriaListResponse = gson.fromJson(json, PasteleriaListResponse::class.java)
//                val pastelesList = pastelesObject.DATA
//                listener.onSucces(pastelesList)
//            }
//
//            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                listener.onError(t.message.toString())
//            }
//        } )
//    }
//}