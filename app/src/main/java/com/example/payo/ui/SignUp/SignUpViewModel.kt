package com.example.payo.ui.SignUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Sign-up Activity."
    }
    val text: LiveData<String> = _text
}