package com.example.lab2.model.service

import com.example.lab2.model.entity.Dog
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("X-Api-Key: x3oPVoyBI0I8ZZ5Jm9NyeCGFEtEQ6vGRMo3ohGNO")
    @GET("dogs")
    fun getDog(@Query("name") name: String): Call<List<Dog>>
}