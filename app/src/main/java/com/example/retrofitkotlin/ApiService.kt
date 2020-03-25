package com.example.retrofitkotlin

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun fetchAllUsers(): Call<List<User>>

}