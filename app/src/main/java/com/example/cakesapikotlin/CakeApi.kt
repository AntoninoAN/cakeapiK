package com.example.cakesapikotlin

import retrofit2.Call
import retrofit2.http.GET

interface CakeApi {
    @GET("cake.json")
    fun getCakes() : Call<List<CakePoko>>
}