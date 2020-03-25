package com.example.retrofitkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var retrofir = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()

        val jsonPlaceHolderApi = retrofir.create(JsonPlaceHolderApi::class.java)

        val myCall: Call<List<User>> = jsonPlaceHolderApi.getUsers()

        myCall.enqueue(object : Callback<List<User>> {

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e("ERROR", t.message.toString())
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {

                val Users: List<User> = response.body()!!
                val stringBuilder = StringBuilder()

                for (user in Users){
                    stringBuilder.append("${user.username} \n")
                    stringBuilder.append("${user.email} \n")
                    stringBuilder.append("${user.id} \n")
                    stringBuilder.append("${user.name} \n\n")
                }
                txtUser.text = stringBuilder
            }
        } )

    }
}
