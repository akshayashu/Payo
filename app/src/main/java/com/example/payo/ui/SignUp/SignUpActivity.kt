package com.example.payo.ui.SignUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.payo.MainActivity
import com.example.payo.R
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        SignUpBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}