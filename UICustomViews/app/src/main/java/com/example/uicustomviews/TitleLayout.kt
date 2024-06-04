package com.example.uicustomviews

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import com.example.uicustomviews.databinding.TitleBinding

class TitleLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    init {
        val titlebinding = TitleBinding.inflate(LayoutInflater.from(context), this, true)
        //LayoutInflater.from(context).inflate(R.layout.title, this)
        titlebinding.titleBack1.setOnClickListener {
            val activity = context as Activity
            activity.finish()
        }
        titlebinding.titleEdit1.setOnClickListener {
            Toast.makeText(context, "You clicked Edit button!", Toast.LENGTH_SHORT).show()
        }
        /*val button1: Button = findViewById(R.id.titleBack)
        val button2: Button = findViewById(R.id.titleEdit)
        button1.setOnClickListener {
            val activity = context as Activity
            activity.finish()
        }
        button2.setOnClickListener {
            Toast.makeText(context, "You clicked Edit button", Toast.LENGTH_SHORT).show()
        }*/
    }
}