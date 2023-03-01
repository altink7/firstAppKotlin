package com.example.firstappkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var count = 0
    companion object {
        const val logTag = "MainActivity"
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(logTag, R.layout.activity_main.toString())
        Log.e(logTag, "onCreate")

        findViewById<TextView>(R.id.textView).text = "Hello World"
        findViewById<Button>(R.id.button2).setOnClickListener {
            count++
            findViewById<TextView>(R.id.textView).text = count.toString()
    }
    }
}