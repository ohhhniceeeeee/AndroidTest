package com.example.providertest

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.contentValuesOf
import com.example.providertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var bookId: String? = null
    val tag_main = "MainActivity"
    val tag_add = "add"
    val tag_query = "query"
    val tag_update = "update"
    val tag_delete = "delete"
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        mainBinding.addData.setOnClickListener {
            val uri = Uri.parse("content://com.example.databasereview.provider/book")
            val values = contentValuesOf(
                "name" to "A Clash of Kings",
                "author" to "George Martin",
                "pages" to 1040,
                "price" to 22.85
            )
            val newUri = contentResolver.insert(uri, values)
            bookId = newUri?.pathSegments?.get(1)
            Log.d(tag_add, "new bookId is $bookId")
            Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show()
        }
        mainBinding.queryData.setOnClickListener {
            val uri = Uri.parse("content://com.example.databasereview.provider/book")
            contentResolver.query(uri, null, null, null, null)?.apply {
                if (moveToFirst()) {
                    do {
                        val name = getString(getColumnIndexOrThrow("name"))
                        val author = getString(getColumnIndexOrThrow("author"))
                        val pages = getInt(getColumnIndexOrThrow("pages"))
                        val price = getDouble(getColumnIndexOrThrow("price"))
                        Log.d(tag_query, "book name is $name")
                        Log.d(tag_query, "book author is $author")
                        Log.d(tag_query, "book pages is $pages")
                        Log.d(tag_query, "book price is $price")
                    } while (moveToNext())
                    close()
                }
            }
            Toast.makeText(this, "Query", Toast.LENGTH_SHORT).show()
        }
        mainBinding.updateData.setOnClickListener {
            Log.d(tag_update, "bookId before update is $bookId")
            bookId?.let {
                val uri = Uri.parse("content://com.example.databasereview.provider/book/$it")
                val values = contentValuesOf(
                    "name" to "A Storm of Swords",
                    "pages" to 1216,
                    "price" to 24.05
                )
                contentResolver.update(uri, values, null, null)
            }
            Toast.makeText(this, "Update", Toast.LENGTH_SHORT).show()
        }
        mainBinding.deleteData.setOnClickListener {
            bookId?.let {
                val uri = Uri.parse("content://com.example.databasereview.provider/book/$it")
                contentResolver.delete(uri, null, null)
            }
            Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show()
        }
    }
}