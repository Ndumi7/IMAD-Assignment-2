package com.example.studyapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review_screen)

        val questions = intent.getStringArrayListExtra("QUESTIONS")
        val correctAnswers = intent.getBooleanArrayExtra("ANSWERS")
        val userAnswers = intent.getBooleanArrayExtra("USER_ANSWERS")

        val reviewTextView = findViewById<TextView>(R.id.reviewText)

        val resultText = StringBuilder()
        for (i in questions!!.indices) {
            val question = questions[i]
            val correct = if (correctAnswers!![i]) "True" else "False"
            val user = if (userAnswers!![i]) "True" else "False"
            val status = if (correctAnswers[i] == userAnswers[i]) "✅" else "❌"
            resultText.append("Q${i + 1}: $question\nYour Answer: $user\nCorrect Answer: $correct $status\n\n")
        }

        reviewTextView.text = resultText.toString()

}
}