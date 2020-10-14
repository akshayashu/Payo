package com.example.payo.ui.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.example.payo.MainActivity
import com.example.payo.R
import com.example.payo.ui.SignUp.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.email
import kotlinx.android.synthetic.main.activity_login.password
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginBtn.setOnClickListener {
            if(checkFields()) {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }

        go_to_signup.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }
    }

    private fun checkFields() : Boolean{

        if(TextUtils.isEmpty(email.text.trim())){
            email.error = "Field is empty!"
            return false
        }
        if(TextUtils.isEmpty(password.text.trim())){
            password.error = "Field is empty!"
            return false
        }
        val pattern1: Pattern = Pattern.compile("^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\\.([a-zA-Z])+([a-zA-Z])+")
        val matcher1: Matcher = pattern1.matcher(email.text.toString().trim())

        if (!matcher1.matches()){
            email.error = "Check your email format!"
            return false
        }
        return true
    }
}