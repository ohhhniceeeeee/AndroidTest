package com.example.activitytest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.activitytest.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val secondBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(secondBinding.root)
        val extradata = intent.getStringExtra("extra_data")
        secondBinding.button2.setOnClickListener {
            Toast.makeText(this, "Received msg :$extradata ", Toast.LENGTH_SHORT).show()
            val intent = Intent()
            intent.putExtra("data_return","Second return to first")
            setResult(RESULT_OK,intent)
            finish()
        }
    }

}