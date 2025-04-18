package com.example.studyapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.studyapp.R.id.appName2

class flashcardScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flashcard_screen)

        val appName2 = findViewById<TextView>(appName2)
        val questionText = findViewById<TextView>(R.id.questionText)
        val falseBtn = findViewById<Button>(R.id.falseBtn)
        val trueBtn = findViewById<Button>(R.id.trueBtn)
        val nextBtn = findViewById<Button>(R.id.nextBtn)

        appName2.text = "Quiztory \uD83C\uDFC6"

        // create the parallel arrays and store the questions and answers in each array
        val questions = arrayOf(
            "The Titanic sank on its maiden voyage in 1912.",
            "The Great Wall of China was built to keep out invaders from the east.",
            "Julius Caesar was assassinated in 44 BC.",
            "Christopher Columbus discovered America in 1492.",
            "The Berlin Wall fell in 1989, symbolizing the end of the Cold War."
        )
        val answers = booleanArrayOf(
            true,
            false,
            true,
            false,
            true
        )

        //initialize the question to 0
        var currentQuestionIndex = 0

        // Set the first question initially
        questionText.text = questions[currentQuestionIndex]
    }
}