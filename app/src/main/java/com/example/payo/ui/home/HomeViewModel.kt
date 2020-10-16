package com.example.payo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.payo.DataModel.MainData
import com.example.payo.Remote.RetroClass

class HomeViewModel : ViewModel() {

    private lateinit var values : List<MainData>
    private val retroClass = RetroClass()

    fun getListData(){

        return retroClass.getData { isSuccess, response ->
            response!!.data
        }
    }


    var data = MutableLiveData<List<MainData>>().apply {
        val retroClass = RetroClass()
        retroClass.getData{ isSuccess, response ->
            if(isSuccess){
                value = response!!.data
            }
        }
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}