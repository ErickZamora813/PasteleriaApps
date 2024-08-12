package com.erick.apppasteleria.data.di

import com.erick.apppasteleria.data.Paths
//import com.google.gson.Gson
//import com.google.gson.GsonBuilder
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object RetrofigModule {
//
//    @Provides
//    @Singleton
//    fun provideRetrofit() : Retrofit{
//        return Retrofit.Builder()
//            .baseUrl(Paths.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideApiService(retrofit: Retrofit) : AppPasteleriaClient{
//        return retrofit.create(AppPasteleriaClient::class.java)
//    }
//
//    @Provides
//    @Singleton
//    fun provideGson() : Gson {
//        return GsonBuilder().create()
//    }
//
//
//}