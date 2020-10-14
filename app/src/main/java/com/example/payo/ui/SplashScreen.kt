package com.example.payo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.payo.R
import com.example.payo.ui.SignUp.SignUpActivity

class SplashScreen : AppCompatActivity() {

    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        startLoginActivity()
    }

    private fun startLoginActivity() {


        mRunnable = Runnable {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }

        mHandler = Handler()

        mHandler.postDelayed(mRunnable, 2000)
    }

    override fun onStop() {
        super.onStop()
        mHandler.removeCallbacks(mRunnable)
    }

}