package com.example.retrofitkotlin

import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceHolderApi {

    @GET("users")
    fun getUsers(): Call<List<User>>

}