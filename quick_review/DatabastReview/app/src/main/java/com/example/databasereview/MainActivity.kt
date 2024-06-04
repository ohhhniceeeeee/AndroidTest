package com.example.databasereview

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.databastreview.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        val dbHelper = MyDatabaseHelper(this, "BookStore.db", 1)
        mainBinding.createDatabase.setOnClickListener {
            dbHelper.writableDatabase
            Toast.makeText(this, "Created Succeed", Toast.LENGTH_SHORT).show()
        }
        mainBinding.addData.setOnClickListener {
            val db = dbHelper.writableDatabase
            val values1 = ContentValues().apply {
                put("name", "The Da Vinci Code")
                put("author", "Dan Brown")
                put("pages", 454)
                put("price", 16.96)
            }
            db.insert("Book", null, values1)
            val values2 = ContentValues().apply {
                put("name", "The Lost Symbol")
                put("author", "Dan Brown")
                put("pages", 510)
                put("price", 19.95)
            }
            db.insert("Book", null, values2)
            Toast.makeText(this, "Add succeed!", Toast.LENGTH_SHORT).show()
        }
        mainBinding.updateData.setOnClickListener {
            val db = dbHelper.writableDatabase
            val values = ContentValues()
            values.put("price", 10.99)
            db.update("Book", values, "name=?", arrayOf("The Da Vinci Code"))
            Toast.makeText(this, "Update Succeed!", Toast.LENGTH_SHORT).show()
        }
        mainBinding.deleteData.setOnClickListener {
            val db = dbHelper.writableDatabase
            db.delete("Book", "pages >?", arrayOf("500"))
            Toast.makeText(this, "Delete Succeed", Toast.LENGTH_SHORT).show()
        }
        mainBinding.queryData.setOnClickListener {
            val tag = "Query"
            val db = dbHelper.writableDatabase
            val cursor = db.query("Book", null, "id = ?", arrayOf("1"), null, null, null)
            if (cursor.moveToFirst()) {
                do {
                    val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                    val author = cursor.getString(cursor.getColumnIndexOrThrow("author"))
                    val pages = cursor.getInt(cursor.getColumnIndexOrThrow("pages"))
                    val price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"))
                    Log.d(tag, "book name is $name")
                    Log.d(tag, "author is $author")
                    Log.d(tag, "pages is $pages")
                    Log.d(tag, "price is $price")

                } while (cursor.moveToNext())
            }
            cursor.close()
        }
        mainBinding.replaceData.setOnClickListener {
            val db = dbHelper.writableDatabase
            db.beginTransaction()
            try {
                db.delete("Book", null, null)
//                if (true) {
//                    throw NullPointerException()
//                }
                val values = ContentValues().apply {
                    put("name", "Game of Thrones")
                    put("author", "George Martin")
                    put("pages", 720)
                    put("price", 20.85)
                }
                db.insert("Book", null, values)
                db.setTransactionSuccessful()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                db.endTransaction()
            }
        }
    }
}