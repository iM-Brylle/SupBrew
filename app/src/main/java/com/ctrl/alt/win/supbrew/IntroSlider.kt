package com.ctrl.alt.win.supbrew

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class IntroSlider : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_slider)

        val nextButton: Button = findViewById(R.id.next_btn)
        val skipButton: TextView = findViewById(R.id.skip_btn) // Get the skip button

        nextButton.setOnClickListener {
            val intent = Intent(this@IntroSlider, SecondSlider::class.java)
            startActivity(intent)
        }

        skipButton.setOnClickListener {  // Set click listener for skip button
            val intent = Intent(this@IntroSlider, Home::class.java) // Go to Home activity
            startActivity(intent)
            finish() // Optional: Finish IntroSlider activity
        }
    }
}