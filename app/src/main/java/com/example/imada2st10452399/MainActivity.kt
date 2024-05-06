package com.example.imada2st10452399

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


                //Button to Navigate to second screen
                val btnStart = findViewById<Button>(R.id.btnStart)
                btnStart.setOnClickListener {
                    val intent = Intent(this@MainActivity, MainActivity2::class.java) // instructing button to leave welcome page
                    startActivity(intent)
        }
    }
}