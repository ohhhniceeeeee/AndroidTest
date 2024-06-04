package com.example.broadcastreview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broadcastreview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        mainBinding.button.setOnClickListener {
            val intent = Intent("com.example.broadcastreview.MY_BROADCAST")
            intent.setPackage(packageName)
//            sendBroadcast(intent)
            sendOrderedBroadcast(intent, null)
        }
    }
}