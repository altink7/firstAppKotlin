package com.example.firstappkotlin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    var count = 0
    companion object {
        const val logTag = "MainActivity"
    }


    @SuppressLint("MissingInflatedId", "StringFormatInvalid", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(logTag, R.layout.activity_main.toString())
        Log.e(logTag, "onCreate")

       /* findViewById<TextView>(R.id.textView).text = "Hello World"
        findViewById<Button>(R.id.button2).setOnClickListener {
            count++
            findViewById<TextView>(R.id.textView).text = getString(R.string.button_counter_text, count)
        } */

        findViewById<Button>(R.id.navigate).setOnClickListener {
            val startSecondActivityIntent = Intent(this, SecondActivity::class.java)
            startSecondActivityIntent.putExtra("COUNTER_VALUE", count)
            startActivity(startSecondActivityIntent)
        }

        var number1 = findViewById<TextInputLayout>(R.id.num1)
        var number2 = findViewById<TextInputLayout>(R.id.num2)

        findViewById<Button>(R.id.submit).setOnClickListener {
            when {
                !number1.editText?.text?.matches(Regex("\\d")) -> {
                    number1.error = "Please enter a valid number"
                    return@setOnClickListener
                }
                !number2.editText?.text?.matches(Regex("\\d"))!! -> {
                    number2.error = "Please enter a valid number"
                    return@setOnClickListener
                }
                else -> {

                    val num1 = number1.editText?.text.toString().toInt()
                    val num2 = number2.editText?.text.toString().toInt()
                    val result = num1 + num2
                    findViewById<TextView>(R.id.result).text = "Result: $result"
                }
            }
        }

    }
}