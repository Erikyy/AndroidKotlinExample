package com.example.myapplication.apiservice


import com.example.myapplication.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*
import kotlin.collections.ArrayList

interface UserAPIService {

    @GET("/all")
    fun getUsers(): Call<ArrayList<User>>
}