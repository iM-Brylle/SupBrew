package com.ctrl.alt.win.supbrew

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.ImageButton
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {

    private lateinit var editTextPassword: EditText // Declare EditText
    private lateinit var showPasswordButton: ImageButton // Declare ImageButton
    private var isPasswordVisible = false // Keep track of visibility

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.log_in) // Make sure this is the correct layout file

        editTextPassword = findViewById(R.id.passinput) // Initialize EditText - Use the correct ID
        showPasswordButton = findViewById(R.id.btnShowPasswordLogin) // Initialize ImageButton - Use the correct ID

        val signupBtn: Button = findViewById(R.id.signupBtn)
        signupBtn.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        val loginBtn : Button = findViewById(R.id.loginBtn)
        loginBtn.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        val forgotPasswordBtn : Button = findViewById(R.id.forgotpassBtn)
        forgotPasswordBtn.setOnClickListener {
            val intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)
        }

        showPasswordButton.setOnClickListener {
            isPasswordVisible = !isPasswordVisible // Toggle visibility state
            togglePasswordVisibility() // Call the function to update the view
            editTextPassword.setSelection(editTextPassword.text.length) // Keep cursor at the end
        }


    }

    private fun togglePasswordVisibility() {
        val passwordTransformationMethod = if (isPasswordVisible) {
            HideReturnsTransformationMethod.getInstance()
        } else {
            PasswordTransformationMethod.getInstance()
        }

        editTextPassword.transformationMethod = passwordTransformationMethod

        showPasswordButton.setImageResource(
            if (isPasswordVisible) {
                R.drawable.ic_hide_password // Make sure you have this drawable
            } else {
                R.drawable.ic_show_password // Make sure you have this drawable
            }
        )
    }
}