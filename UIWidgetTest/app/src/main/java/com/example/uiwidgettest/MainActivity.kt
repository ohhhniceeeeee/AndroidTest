package com.example.uiwidgettest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.VelocityTracker
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.uiwidgettest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainbinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainbinding.root)
        mainbinding.button1.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Dialog")
                setMessage("提示信息")
                setCancelable(false)
                setPositiveButton("ok") { dialog, which ->
                }
                setNegativeButton("cancel") { dialog, which ->
                }
                show()
            }
        }
    }

    /*override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.button1 -> {
                mainbinding.progressBar1.progress = mainbinding.progressBar1.progress + 10
                *//*if (mainbinding.progressBar1.visibility == View.VISIBLE) {
                    mainbinding.progressBar1.visibility = View.GONE
                } else
                    mainbinding.progressBar1.visibility = View.VISIBLE*//*
            }
        }
    }*/
}