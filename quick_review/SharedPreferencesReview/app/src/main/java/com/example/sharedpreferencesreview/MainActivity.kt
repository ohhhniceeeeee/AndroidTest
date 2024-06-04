package com.example.sharedpreferencesreview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sharedpreferencesreview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private val tag = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        mainBinding.saveButton.setOnClickListener {
            val inputText = mainBinding.editText.text.toString()
            if (inputText.isNotEmpty()) {
                val editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
                editor.apply {
                    putString("inputText", inputText)
                    putString("name", "Aname")
                    putInt("age", 11)
                    putBoolean("married", false)
                    apply()
                }
            }
        }
        mainBinding.restoreButton.setOnClickListener {
            val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
            val inputText = prefs.getString("inputText", "")
            val name = prefs.getString("name", "default Name")
            val age = prefs.getInt("age", 0)
            val married = prefs.getBoolean("married", false)
            if (!inputText.isNullOrEmpty()) {
                mainBinding.editText.setText(inputText)
            }
            Log.d(tag, "name is $name")
            Log.d(tag, "age is $age")
            Log.d(tag, "married is $married")

        }
    }
}