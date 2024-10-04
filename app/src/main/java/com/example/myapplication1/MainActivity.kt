package com.example.myapplication1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNumber: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumber = findViewById(R.id.editTextNumber)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        textViewResult = findViewById(R.id.textViewResult)

        buttonCalculate.setOnClickListener {
            val n = editTextNumber.text.toString().toIntOrNull()

            if (n != null && n > 0) {
                val result = sumOfReciprocalsOfFactorials(n)
                textViewResult.text = "Сумма 1/1! + 1/2! + ... + 1/$n! равна $result"
            } else {
                textViewResult.text = "Пожалуйста, введите число больше 0."
            }
        }
    }

    private fun factorial(n: Int): Double {
        var result = 1.0
        for (i in 1..n) {
            result *= i // Умножаем результат на текущее значение i
        }
        return result
    }

    private fun sumOfReciprocalsOfFactorials(n: Int): Double {
        var sum = 0.0
        for (i in 1..n) {
            sum += 1 / factorial(i) // Добавляем обратное значение факториала к сумме
        }
        return sum
    }
}