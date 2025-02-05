package com.ctrl.alt.win.supbrew// Replace with your actual package name

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class ChangePassword: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.change_password) // Replace with your layout file name

        val currentPasswordEditText = findViewById<EditText>(R.id.currentpassword)
        val newPasswordEditText = findViewById<EditText>(R.id.newpassword)
        val repeatNewPasswordEditText = findViewById<EditText>(R.id.repeatnewpassword)

        val showPasswordButton1 = findViewById<ImageButton>(R.id.btnShowPassword1)
        val showPasswordButton2 = findViewById<ImageButton>(R.id.btnShowPassword2)
        val showPasswordButton3 = findViewById<ImageButton>(R.id.btnShowPassword3)
        val backButton = findViewById<ImageButton>(R.id.backBtn)


        //Password Input Type for security
        currentPasswordEditText.inputType = android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
        newPasswordEditText.inputType = android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
        repeatNewPasswordEditText.inputType = android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD


        showPasswordButton1.setOnClickListener { togglePasswordVisibility(currentPasswordEditText, showPasswordButton1) }
        showPasswordButton2.setOnClickListener { togglePasswordVisibility(newPasswordEditText, showPasswordButton2) }
        showPasswordButton3.setOnClickListener { togglePasswordVisibility(repeatNewPasswordEditText, showPasswordButton3) }

        backButton.setOnClickListener {
            onBackPressed() // or finish(), depending on desired behavior
        }


    }

    private fun togglePasswordVisibility(editText: EditText, button: ImageButton) {
        val currentVisibility = editText.transformationMethod
        if (currentVisibility is PasswordTransformationMethod) {
            // Show password
            editText.transformationMethod = null
            button.setImageResource(R.drawable.ic_hide_password) // Change to a "hide" icon. Make sure ic_hide_password is available.
        } else {
            // Hide password
            editText.transformationMethod = PasswordTransformationMethod()
            button.setImageResource(R.drawable.ic_show_password) // Change back to "show" icon
        }
        editText.setSelection(editText.text.length) // Keep cursor at the end
    }
}