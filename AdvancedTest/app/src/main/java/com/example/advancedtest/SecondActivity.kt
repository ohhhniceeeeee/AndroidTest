package com.example.advancedtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.advancedtest.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var secondBinding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        secondBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(secondBinding.root)
        secondBinding.getBtn.setOnClickListener {
//            val person = intent.getSerializable("person_data", Person::class.java)
//            Toast.makeText(this, "age is ${person.age},name is ${person.name}", Toast.LENGTH_SHORT)
//                .show()
            val person = intent.getParcelable("person_data", Person::class.java)
            Toast.makeText(this, "age is ${person?.age},name is ${person?.name}", Toast.LENGTH_SHORT)
                .show()
        }

    }
}