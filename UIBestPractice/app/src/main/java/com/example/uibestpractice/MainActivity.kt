package com.example.uibestpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uibestpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var mainActivitybinding: ActivityMainBinding
    private val msgList = ArrayList<Msg>()
    private lateinit var adapter: MsgAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivitybinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivitybinding.root)
        initMsg()
        val layoutManager = LinearLayoutManager(this)
        mainActivitybinding.recyclerView1.layoutManager = layoutManager
        //adapter = MsgAdapter(msgList)
        if (!::adapter.isInitialized) {
            adapter = MsgAdapter(msgList)
        }
        mainActivitybinding.recyclerView1.adapter = adapter
        mainActivitybinding.buttonSend.setOnClickListener(this)
    }

    private fun initMsg() {
        val msg1 = Msg("Hello yooooooooo", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("Hello tooooooooo", Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("Receive msg", Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }

    override fun onClick(p0: View?) {
        when (p0) {
            mainActivitybinding.buttonSend -> {
                val content = mainActivitybinding.inputText.text.toString()
                if (content.isNotEmpty()) {
                    val msg = Msg(content, Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter.notifyItemInserted(msgList.size - 1)
                    mainActivitybinding.recyclerView1.scrollToPosition(msgList.size - 1)
                    mainActivitybinding.inputText.setText("")
                }
            }
        }
    }
}