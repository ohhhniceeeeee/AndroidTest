package com.example.advancedtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.advancedtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        mainBinding.sendBtn.setOnClickListener {
            val person = Person()
            person.name = "aaa"
            person.age = 10
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("person_data", person)
            startActivity(intent)
        }
    }

}