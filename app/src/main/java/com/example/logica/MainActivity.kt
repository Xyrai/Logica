package com.example.logica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var quizLevel: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSubmit.setOnClickListener {
            checkAnswers(
                etAnswer1.text.toString(),
                etAnswer2.text.toString(),
                etAnswer3.text.toString(),
                etAnswer4.text.toString()
            )
        }
    }

    private fun checkAnswers(answer1: String, answer2: String, answer3: String, answer4: String) {
        if (answer1.isEmpty() || answer2.isEmpty() || answer3.isEmpty() || answer4.isEmpty()) {
            Toast.makeText(this, getString(R.string.empty_field), Toast.LENGTH_SHORT).show()
            return
        }

        if (quizLevel == 1 && answer1 == R.string.letter_T.toString() &&
            answer2 == R.string.letter_F.toString() &&
            answer3 == R.string.letter_F.toString() &&
            answer4 == R.string.letter_F.toString()
        ) {
            Toast.makeText(this, getString(R.string.correct_answer), Toast.LENGTH_SHORT).show()
            resetFields()
            moveToDisjunctionLevel()
        } else {
            if (answer1 == R.string.letter_T.toString() &&
                answer2 == R.string.letter_T.toString() &&
                answer3 == R.string.letter_T.toString() &&
                answer4 == R.string.letter_F.toString()
            ) {
                Toast.makeText(this, getString(R.string.finish), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun moveToDisjunctionLevel() {
        quizLevel = 2
        tvTitle.setText(R.string.disjunction)
        resetFields()
    }

    private fun resetFields() {
        etAnswer1.text.clear()
        etAnswer2.text.clear()
        etAnswer3.text.clear()
        etAnswer4.text.clear()
    }
}
