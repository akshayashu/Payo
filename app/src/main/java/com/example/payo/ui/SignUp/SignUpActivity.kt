package com.example.payo.ui.SignUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.example.payo.MainActivity
import com.example.payo.R
import com.example.payo.ui.Login.LoginActivity
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        SignUpBtn.setOnClickListener {

            if (checkFields()) {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }

        go_to_login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun checkFields() : Boolean {

        if(TextUtils.isEmpty(first_name.text.trim())){
            first_name.error = "Field is empty!"
            return false
        }
        if(TextUtils.isEmpty(last_name.text.trim())){
            last_name.error = "Field is empty!"
            return false
        }
        if(TextUtils.isEmpty(email.text.trim())){
            email.error = "Field is empty!"
            return false
        }
        if(TextUtils.isEmpty(password.text.trim())){
            password.error = "Field is empty!"
            return false
        }
        if(TextUtils.isEmpty(confirm_password.text.trim())){
            confirm_password.error = "Field is empty!"
            return false
        }
        if(TextUtils.isEmpty(mobile_no.text.trim())){
            mobile_no.error = "Field is empty!"
            return false
        }
        if(TextUtils.isEmpty(address.text.trim())){
            address.error = "Field is empty!"
            return false
        }

        if(password.text.trim() != confirm_password.text.trim()){
            confirm_password.error = "Password doesn't match!"
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