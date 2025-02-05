package com.ctrl.alt.win.supbrew

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_maininterface)

        val paymentButton = findViewById<Button>(R.id.paymentButton)
        paymentButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java) // Replace PaymentMethodsActivity
            startActivity(intent)
        }

        val changepassButton = findViewById<Button>(R.id.changepassButton)
        changepassButton.setOnClickListener {
            val intent = Intent(this, ChangePassword::class.java) // Replace PaymentMethodsActivity
            startActivity(intent)
        }

    }
}