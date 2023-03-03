package com.abit8.lovecalculator

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun calculatePersentage(
        @Query("sname") secondName: String,
        @Query("fname") firstName: String,
        @Header("X-RapidAPI-Key") key: String = "f60f2798a0msh70e8c72663a195fp1f03bajsnd3db520e549a",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com",
    ): Call<LoveModel>

}