package com.example.payo.Remote

import android.util.Log
import android.widget.Toast
import com.example.payo.DataModel.MainData
import com.example.payo.DataModel.PayoData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroClass {

    private val url = "https://reqres.in/api/"

    private fun getRetroInstance() : Retrofit{

        return Retrofit.Builder().
        baseUrl(url).
        addConverterFactory(GsonConverterFactory.create()).
        build()
    }

    private fun getApiServices() : APIServices{
        return getRetroInstance().create(APIServices::class.java)
    }

    fun getData(onResult: (isSuccess: Boolean, response: PayoData?) -> Unit){

        val apiServices = getApiServices()

        apiServices.getData().enqueue(object : Callback<PayoData>{
            override fun onResponse(call: Call<PayoData>, response: Response<PayoData>) {
               if(response.isSuccessful){
                   onResult(true, response.body()!!)
               } else {
                   onResult(false, null)
               }
            }

            override fun onFailure(call: Call<PayoData>, t: Throwable) {
                onResult(false, null)
                Log.d("ERRORRRRR", t.localizedMessage!!)
            }
        })
    }
}