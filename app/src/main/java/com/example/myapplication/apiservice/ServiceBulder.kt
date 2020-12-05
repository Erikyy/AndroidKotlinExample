package com.example.myapplication.apiservice

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBulder {
    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
    .baseUrl("http://url:8080")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun<T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}