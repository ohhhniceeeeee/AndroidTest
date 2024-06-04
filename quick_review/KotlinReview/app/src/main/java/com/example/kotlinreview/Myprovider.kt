package com.example.kotlinreview

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import android.os.CancellationSignal

class MyProvider : ContentProvider() {
    private val table1Dir = 0
    private val table1Item = 1
    private val table2Dir = 2
    private val table2Item = 3
    private val authority = "com.example.kotlinreview.provider"//app->kotlinreview ###包名加上.provider
    private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH)

    private val typeBegin = "vnd.android.cursor."
    private val typeEnd = "/vnd.com.example.kotlinreview.provider."

    init {
        uriMatcher.addURI(authority, "table1", table1Dir)
        uriMatcher.addURI(authority, "table/#", table1Item)
        uriMatcher.addURI(authority, "table2", table2Dir)
        uriMatcher.addURI(authority, "table2/#", table2Item)
    }

    override fun onCreate(): Boolean {
        return false
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        when (uriMatcher.match(p0)) {
            table1Dir -> {}
            table1Item -> {}
            table2Dir -> {}
            table2Item -> {}
        }
        return null
    }

    //typeBegin = "vnd.android.cursor."
    //typeEnd = "/vnd.com.example.kotlinreview.provider."
    override fun getType(p0: Uri) = when (uriMatcher.match(p0)) {
        table1Dir -> typeBegin + "dir" + typeEnd + "table1"
        table1Item -> typeBegin + "item" + typeEnd + "table1"
        table2Dir -> typeBegin + "dir" + typeEnd + "table2"
        table2Item -> typeBegin + "item" + typeEnd + "table2"
        else -> null
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        return null
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        return 0
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        return 0
    }

}