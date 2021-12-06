package com.example.mapexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var activityButton:Button
    private lateinit var fragmentButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityButton = findViewById(R.id.button_activity)
        fragmentButton = findViewById(R.id.button_fragment)
        activityButton.setOnClickListener {
            startActivity(Intent(this,MapsActivity::class.java))
        }
        fragmentButton.setOnClickListener {
            startActivity(Intent(this,FragmentHolderActivity::class.java))
        }
    }
}