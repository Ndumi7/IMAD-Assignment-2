package com.example.studyapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // create the variables
        val appName = findViewById<TextView>(R.id.appName)
        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        val welcomeMessage = findViewById<TextView>(R.id.welcomeMessage)
        val getStartedBtn = findViewById<Button>(R.id.getStartedBtn)

        // get the Text Views and input text
        appName.text = "Quiztory \uD83C\uDFC6"
        welcomeText.text = "Welcome to Quiztory!"
        welcomeMessage.text = "Dive into the past and see how much history you really know. Ready to test your knowledge?"

        // create onclick function for the button
        getStartedBtn?.setOnClickListener {
            val intent = Intent (this, flashcardScreen::class.java)
            startActivity(intent)
        }


    }
}