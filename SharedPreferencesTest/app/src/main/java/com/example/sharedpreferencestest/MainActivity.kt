package com.example.sharedpreferencestest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.compose.ui.platform.LocalDensity
import com.example.sharedpreferencestest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        mainBinding.saveButton.setOnClickListener {
            getSharedPreferences("data", Context.MODE_PRIVATE).open {
                putString("name", "Jack")
                putInt("age", 12)
                putBoolean("married", false)
            }
            /*val editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit().apply {
                putString("name", "Jack")
                putInt("age", 12)
                putBoolean("married", false)
                apply()
            }*/
        }
        mainBinding.restoreButton.setOnClickListener {
            val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
            val name = prefs.getString("name", "")
            val age = prefs.getInt("age", 0)
            val married = prefs.getBoolean("married", false)
            Log.d("MainActivity", "name is ${name}")
            Log.d("MainActivity", "age is ${age}")
            Log.d("MainActivity", "married is ${married}")
        }
    }
}