package com.ctrl.alt.win.supbrew

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.activity.enableEdgeToEdge

class IntroSlider : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_slider)

        val nextButton: Button = findViewById(R.id.next_btn)

        nextButton.setOnClickListener {
            val intent = Intent(this@IntroSlider, SecondSlider::class.java)
            startActivity(intent)
        }
    }
}