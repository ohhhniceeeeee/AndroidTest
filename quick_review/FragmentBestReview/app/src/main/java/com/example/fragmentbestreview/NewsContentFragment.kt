package com.example.fragmentbestreview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentbestreview.databinding.NewsContentFragBinding

class NewsContentFragment : Fragment() {
    private lateinit var newsContentFragBinding: NewsContentFragBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newsContentFragBinding = NewsContentFragBinding.inflate(inflater, container, false)
        return newsContentFragBinding.root
    }

    fun refresh(title: String, content: String) {
        newsContentFragBinding.contentLayout.visibility = View.VISIBLE
        newsContentFragBinding.newsTitle.text = title
        newsContentFragBinding.newsContent.text = content
    }
}