package com.example.databasetest

import android.app.Activity
import android.content.ContentValues
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.contentValuesOf
import androidx.core.database.getDoubleOrNull
import androidx.core.database.getIntOrNull
import androidx.core.database.getStringOrNull
import com.example.databasetest.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    var bookId: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        //val dbHelper = MyDatabaseHelper(this, "BookStore.db", 3)
        mainBinding.addData.setOnClickListener {
            val uri = Uri.parse("content://com.example.databasetest.provider/book")
            val values = contentValuesOf(
                "name" to "A Clash of Kings",
                "author" to "George Martin",
                "pages" to 1040,
                "price" to 22.85
            )
            val newUri = contentResolver.insert(uri, values)
            bookId = newUri?.pathSegments?.get(1)
        }
        mainBinding.queryData.setOnClickListener {
            val uri = Uri.parse("content://com.example.databasetest.provider/book")
            contentResolver.query(uri, null, null, null, null, null)?.apply {
                while (moveToNext()) {
                    val name = getStringOrNull(getColumnIndex("name"))
                    val author = getStringOrNull(getColumnIndex("author"))
                    val pages = getIntOrNull(getColumnIndex("pages"))
                    val price = getDoubleOrNull(getColumnIndex("price"))
                    Log.d("MainActivity", "book name is $name")
                    Log.d("MainActivity", "author name is $author")
                    Log.d("MainActivity", "pages is $pages")
                    Log.d("MainActivity", "price is $price")
                }
                close()
            }
        }
        mainBinding.updateData.setOnClickListener {
            bookId?.let {
                val uri = Uri.parse("content://com.example/databasetest.provider/book/$it")
                val values = contentValuesOf(
                    "name" to "A Storm of Swords",
                    "pages" to "1216",
                    "price" to 24.05
                )
                contentResolver.update(uri, values, null, null)
            }
        }
        mainBinding.deleteData.setOnClickListener {
            bookId?.let {
                val uri = Uri.parse("content://com.example.databasetest.provider/book/$it")
                contentResolver.delete(uri, null, null)
            }
        }
    }
}