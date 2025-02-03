package com.ctrl.alt.win.supbrew

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

class SecondSlider : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.second_slider)

        val nextButton: Button = findViewById(R.id.next_btn)

        nextButton.setOnClickListener {
            val intent = Intent(this@SecondSlider, ThirdSlider::class.java)
            startActivity(intent)
        }
    }
}