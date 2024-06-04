package com.example.fragmentreview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fragmentreview.databinding.LeftFragmentBinding

class LeftFragment : Fragment() {
    private lateinit var leftFragmentBinding: LeftFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        leftFragmentBinding = LeftFragmentBinding.inflate(inflater, container, false)
        leftFragmentBinding.button.setOnClickListener {
            Toast.makeText(activity, "aaa", Toast.LENGTH_SHORT).show()
//            replaceFragment(AnotherRightFragment())
        }
//        replaceFragment(RightFragment())
        return leftFragmentBinding.root
    }

//    private fun replaceFragment(fragment: Fragment) {
//        val fragmentManager = requireActivity().supportFragmentManager
//        val transaction = fragmentManager.beginTransaction()
//        transaction.replace(R.id.rightLayout, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//    }
}