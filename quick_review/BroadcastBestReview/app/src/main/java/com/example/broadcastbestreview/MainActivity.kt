package com.example.broadcastbestreview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broadcastbestreview.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        mainBinding.finishButton.setOnClickListener {
            val intent = Intent("com.example.broadcastbestreview.FORCE_OFFLINE")
            sendBroadcast(intent)
        }
    }
}