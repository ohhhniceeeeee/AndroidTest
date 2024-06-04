package com.example.fragmentbestpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragmentbestpractice.databinding.ActivityNewsContentBinding
import com.example.fragmentbestpractice.databinding.NewsContentFragBinding

class NewsContentFragment : Fragment() {
    private var _binding: NewsContentFragBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            NewsContentFragBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    fun refreash(title: String, content: String) {
        _binding?.contentLayout?.visibility = View.VISIBLE
        _binding?.newsTitle?.text = title
        _binding?.newsContent?.text = content
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}