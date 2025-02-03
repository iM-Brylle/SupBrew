package com.ctrl.alt.win.supbrew

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThirdSlider : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.third_slider)

        val trynowButton: Button = findViewById(R.id.trynowButton)

        trynowButton.setOnClickListener {
            val intent = Intent(this@ThirdSlider, Login::class.java)
            startActivity(intent)
        }
    }
}