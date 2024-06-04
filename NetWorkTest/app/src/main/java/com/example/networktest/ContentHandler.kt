package com.example.networktest

import android.util.Log
import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler


class ContentHandler : DefaultHandler() {
    private val myTag = "ContentHandler"
    private var nodeName = ""
    private lateinit var id: StringBuilder
    private lateinit var name: StringBuilder
    private lateinit var version: StringBuilder

    override fun startDocument() {
        id = StringBuilder()
        name = StringBuilder()
        version = StringBuilder()
    }

    override fun startElement(
        uri: String,
        localName: String,
        qName: String,
        attributes: Attributes
    ) {
        nodeName = localName
        Log.d(myTag, "uri is $uri")
        Log.d(myTag, "localName is $localName")
        Log.d(myTag, "qName is $qName")
        Log.d(myTag, "attributes is $attributes")
    }

    override fun characters(ch: CharArray?, start: Int, length: Int) {
        when (nodeName) {
            "id" -> id.append(ch, start, length)
            "name" -> name.append(ch, start, length)
            "version" -> version.append(ch, start, length)
        }
    }

    override fun endElement(uri: String?, localName: String?, qName: String?) {
        if ("app" == localName) {
            Log.d(myTag, "id is ${id.toString().trim()}")
            Log.d(myTag, "name is ${name.toString().trim()}")
            Log.d(myTag, "version is ${version.toString().trim()}")
            id.setLength(0)
            name.setLength(0)
            version.setLength(0)
        }
    }

    override fun endDocument() {

    }
}