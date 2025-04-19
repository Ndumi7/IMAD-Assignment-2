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
import org.w3c.dom.Text

class score_screen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)

        // create the variables
        val appName3 = findViewById<TextView>(R.id.appName3)
        val score = intent.getIntExtra("SCORE", 0)
        val total = intent.getIntExtra("TOTAL", 0)

        // get the Text Views and input text
        appName3.text = "Quiztory \uD83C\uDFC6"
        val scoreTextView = findViewById<TextView>(R.id.scoreText)
        scoreTextView.text = "Your Score: $score / $total"

        val resultText = findViewById<TextView>(R.id.resultText)
        if (score > 4) {
            resultText.text = "Woohoo \uD83C\uDF89, a perfect score \uD83D\uDCAF"
        } else if (score >= 3) {
            resultText.text = "Congrats \uD83C\uDF89, you passed ✅"
        }
        else {
            resultText.text = "Keep practicing \uD83D\uDCAA"
        }

        val questions = intent.getStringArrayListExtra("QUESTIONS")!!
        val answers = intent.getBooleanArrayExtra("ANSWERS")!!
        val userAnswers = intent.getBooleanArrayExtra("USER_ANSWERS")!!



        val reviewBtn = findViewById<Button>(R.id.reviewBtn)
        reviewBtn.setOnClickListener {
            val intent = Intent(this, ReviewScreen::class.java)

            // Passing the actual data (questions, answers, and user answers)
            intent.putStringArrayListExtra("QUESTIONS", (questions)) // pass the actual questions list
            intent.putExtra("ANSWERS", answers) // pass correct answers
            intent.putExtra("USER_ANSWERS", userAnswers) // pass user's answers

            // Start the ReviewScreen activity
            startActivity(intent)
            // Optional: If you want to clear the current activity from the back stack (so you can't go back to it)
            finish()
        }


    }
}