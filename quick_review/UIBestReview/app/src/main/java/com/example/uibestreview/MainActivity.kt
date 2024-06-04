package com.example.uibestreview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uibestreview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val msgList = ArrayList<Msg>()
    private lateinit var adapter: MsgAdapter
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        initMsg()
        val layoutManager = LinearLayoutManager(this)
        mainBinding.recyclerView.layoutManager = layoutManager
        if (!::adapter.isInitialized) {
            adapter = MsgAdapter(msgList)
        }
        mainBinding.recyclerView.adapter = adapter
        mainBinding.send.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v) {
            mainBinding.send -> {
                val content = mainBinding.inputText.text.toString()
                if (content.isNotEmpty()) {
                    val msg = Msg(content, Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter.notifyItemInserted(msgList.size - 1)
                    mainBinding.recyclerView.scrollToPosition(msgList.size - 1)
                    mainBinding.inputText.setText("")
                }
            }
        }
    }

    private fun initMsg() {
        val msg1 = Msg("msg1", Msg.TYPE_SENT)
        val msg2 = Msg("msg2", Msg.TYPE_RECEIVED)
        val msg3 = Msg("msg3", Msg.TYPE_SENT)
        msgList.apply {
            add(msg1)
            add(msg2)
            add(msg3)
        }
    }
}