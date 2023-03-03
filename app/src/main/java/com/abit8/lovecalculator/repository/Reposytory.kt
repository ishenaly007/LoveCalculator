package com.abit8.lovecalculator.repository

import androidx.lifecycle.MutableLiveData
import com.abit8.lovecalculator.remote.LoveModel
import com.abit8.lovecalculator.remote.LoveService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getLove(firstname: String, secondName: String): MutableLiveData<LoveModel> {
        val liveLoveData = MutableLiveData<LoveModel>()
        LoveService().api.calculatePersentage(firstname, secondName).enqueue(object :
            Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    liveLoveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {

            }

        })
        return liveLoveData
    }
}