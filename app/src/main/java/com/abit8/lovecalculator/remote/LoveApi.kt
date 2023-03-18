package com.abit8.lovecalculator.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun calculatePercentage(
        @Query("fname") firstname: String, @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "0890499db8mshb0e929c0115697fp150074jsn9f89d8a52be2",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ): Call<LoveModel>
}