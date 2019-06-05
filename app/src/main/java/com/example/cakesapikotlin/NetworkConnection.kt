package com.example.cakesapikotlin

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkConnection {

    companion object{
        fun initRetrofit(something : Callback<List<CakePoko>>){
            val retrofit = Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com/hart88/198f29ec5114a3ec3460/raw/8dd19a88f9b8d24c23d9960f3300d0c917a4f07c/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CakeApi::class.java)
                .getCakes()
                .enqueue(something)
        }
    }
}