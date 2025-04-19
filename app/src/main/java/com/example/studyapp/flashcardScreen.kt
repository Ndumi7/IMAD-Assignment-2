package com.example.studyapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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

        val userAnswers = mutableListOf<Boolean>()



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
        //initialize the score counter to 0
        var scoreCount = 0

        //initialize the question to 0
        var currentQuestionIndex = 0

        // Set the first question initially
        questionText.text = questions[currentQuestionIndex]

        var userAnswer: Boolean? = null


        trueBtn.setOnClickListener {
            userAnswers.add(true)
            userAnswer = true // Store the answer as true
            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
        }

        falseBtn.setOnClickListener {
            userAnswers.add(false)
            userAnswer = false // Store the answer as false
            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
        }


        nextBtn.setOnClickListener {
            val correctAnswer = answers[currentQuestionIndex]

            // Only check score if the user selected an answer
            if (userAnswer != null) {
                if (userAnswer == correctAnswer) {
                    scoreCount++ // Add to score
                    Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please select an answer!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Don't move to next question yet
            }

            // Move to next question
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                questionText.text = questions[currentQuestionIndex]
                userAnswer = null // Reset for next question
            } else {
                questionText.text = "🎉 Quiz Complete!"
                nextBtn.isEnabled = false
                trueBtn.isEnabled = false
                falseBtn.isEnabled = false
                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this, score_screen::class.java)
                    intent.putExtra("SCORE", scoreCount)
                    intent.putExtra("TOTAL", questions.size)
                    intent.putStringArrayListExtra("QUESTIONS", ArrayList(questions.toList()))
                    intent.putExtra("ANSWERS", answers)
                    intent.putExtra("USER_ANSWERS", userAnswers.toBooleanArray())

                    startActivity(intent)
                }, 2000)
            }
        }
    }
}