package com.example.fragmenttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.fragmenttest.databinding.ActivityMainBinding
import com.example.fragmenttest.databinding.LeftFragmentBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        /*val button1 =
            supportFragmentManager.findFragmentById(R.id.leftFrag)?.view?.findViewById<Button>(R.id.button1)
        button1?.setOnClickListener {
            replaceFragment(AnotherRightFragment())
        }
        replaceFragment(RightFragment())*/
    }

    /*private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.rightLayout1, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }*/
}