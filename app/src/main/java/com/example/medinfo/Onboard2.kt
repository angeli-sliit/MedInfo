package com.example.medinfo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Onboard2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard2)

        val nextButton = findViewById<Button>(R.id.button)
        nextButton.setOnClickListener {
            val intent = Intent(this, Onboard3::class.java)
            startActivity(intent)
        }
    }
}