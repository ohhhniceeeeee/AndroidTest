package com.example.listviewreview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.listviewreview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val fruitList = ArrayList<Fruit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val listview1:ListView = findViewById(R.id.listView)
        val mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        initFruits()
        val adapter = FruitAdapter(this, R.layout.fruit_item, fruitList)
        mainBinding.listView.adapter = adapter
//        listview1.adapter=adapter
        mainBinding.listView.setOnItemClickListener { parent, view, position, id ->
            val fruit = fruitList[position]
            Toast.makeText(this, fruit.name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initFruits() {
        repeat(2) {
//            fruitList.add(Fruit(getRandomLengthString("Apple"), R.drawable.apple_pic))
//            fruitList.add(Fruit(getRandomLengthString("Banana"), R.drawable.banana_pic))
//            fruitList.add(Fruit(getRandomLengthString("Orange"), R.drawable.orange_pic))
//            fruitList.add(Fruit(getRandomLengthString("Watermelon"), R.drawable.watermelon_pic))
//            fruitList.add(Fruit(getRandomLengthString("Pear"), R.drawable.pear_pic))
//            fruitList.add(Fruit(getRandomLengthString("Grape"), R.drawable.grape_pic))
//            fruitList.add(Fruit(getRandomLengthString("Pineapple"), R.drawable.pineapple_pic))
//            fruitList.add(Fruit(getRandomLengthString("Strawberry"), R.drawable.strawberry_pic))
//            fruitList.add(Fruit(getRandomLengthString("Cherry"), R.drawable.cherry_pic))
//            fruitList.add(Fruit(getRandomLengthString("Mango"), R.drawable.mango_pic))
            fruitList.add(Fruit("Apple", R.drawable.apple_pic))
            fruitList.add(Fruit("Banana", R.drawable.banana_pic))
            fruitList.add(Fruit("Orange", R.drawable.orange_pic))
            fruitList.add(Fruit("Watermelon", R.drawable.watermelon_pic))
            fruitList.add(Fruit("Pear", R.drawable.pear_pic))
            fruitList.add(Fruit("Grape", R.drawable.grape_pic))
            fruitList.add(Fruit("Pineapple", R.drawable.pineapple_pic))
            fruitList.add(Fruit("Strawberry", R.drawable.strawberry_pic))
            fruitList.add(Fruit("Cherry", R.drawable.cherry_pic))
            fruitList.add(Fruit("Mango", R.drawable.mango_pic))
        }
    }

    private fun getRandomLengthString(string: String): String {
        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n) {
            builder.append(string)
        }
        return builder.toString()
    }
}