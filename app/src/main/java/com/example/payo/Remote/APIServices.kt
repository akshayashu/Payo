package com.example.payo.Remote

import com.example.payo.DataModel.PayoData
import retrofit2.Call
import retrofit2.http.GET

interface APIServices {

    @GET("users?page=1")
    fun getData() : Call<PayoData>

}