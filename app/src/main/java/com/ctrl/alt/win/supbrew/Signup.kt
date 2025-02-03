package com.ctrl.alt.win.supbrew

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUp : AppCompatActivity() {

    private lateinit var editTextPassword: EditText
    private lateinit var showPasswordButton: ImageButton
    private var isPasswordVisible = false

    private lateinit var repeatpasswordEt: EditText
    private lateinit var showPasswordSignup: ImageButton
    private var isPasswordVisible2 = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)

        editTextPassword = findViewById(R.id.passwordEt)
        showPasswordButton = findViewById(R.id.btnShowPasswordSignUp1)

        repeatpasswordEt = findViewById(R.id.repeatpass)
        showPasswordSignup = findViewById(R.id.btnShowPasswordSignup2)

        val loginBtn: Button = findViewById(R.id.loginBtn)
        loginBtn.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        showPasswordButton.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            togglePasswordVisibility(editTextPassword, showPasswordButton, isPasswordVisible) // Call with correct parameters
            editTextPassword.setSelection(editTextPassword.text.length)

            val message = if (isPasswordVisible) "Password Visible" else "Password Hidden"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        showPasswordSignup.setOnClickListener {
            isPasswordVisible2 = !isPasswordVisible2
            togglePasswordVisibility(repeatpasswordEt, showPasswordSignup, isPasswordVisible2) // Call with correct parameters
            repeatpasswordEt.setSelection(repeatpasswordEt.text.length)

            val message = if (isPasswordVisible2) "Repeat Password Visible" else "Repeat Password Hidden"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun togglePasswordVisibility(editText: EditText, showButton: ImageButton, isVisible: Boolean) { // Function now takes parameters
        val transformationMethod = if (isVisible) {
            HideReturnsTransformationMethod.getInstance()
        } else {
            PasswordTransformationMethod.getInstance()
        }

        editText.transformationMethod = transformationMethod

        showButton.setImageResource(
            if (isVisible) {
                R.drawable.ic_hide_password
            } else {
                R.drawable.ic_show_password
            }
        )
    }
}