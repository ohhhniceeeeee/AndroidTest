package com.example.fragmentbestpractice

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentbestpractice.databinding.ActivityMainBinding
import com.example.fragmentbestpractice.databinding.NewsTitleFragBinding


class NewsTitleFragment : Fragment() {
    lateinit var mainBinding: ActivityMainBinding
    private var isTwoPane = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_title_frag, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                isTwoPane = (activity?.findViewById<View>(R.id.newsContentLayout) != null)
                val layoutManager = LinearLayoutManager(activity)
                activity?.findViewById<RecyclerView>(R.id.newsTitleRecyclerView)?.layoutManager =
                    layoutManager
                val adapter = NewsAdapter(getNews())
                view?.findViewById<RecyclerView>(R.id.newsTitleRecyclerView)?.adapter = adapter
                owner.lifecycle.removeObserver(this)
            }
        })
    }

    private fun getNews(): List<News> {
        val newsList = ArrayList<News>()
        for (i in 1..50) {
            val news = News("News Title$i", getRandomLengthString("News Content$i"))
            newsList.add(news)
        }
        return newsList
    }

    private fun getRandomLengthString(str: String) = str * (1..20).random()

    inner class NewsAdapter(val newsList: List<News>) :
        RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val newsTitle: TextView = view.findViewById(R.id.newsTitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
            val holder = ViewHolder(view)
            holder.itemView.setOnClickListener {
                val news = newsList[holder.bindingAdapterPosition]
                if (isTwoPane) {
                    val fragment =
                        activity!!.supportFragmentManager.findFragmentById(R.id.newsContentFrag) as NewsContentFragment
                    fragment.refreash(news.title, news.content)
                } else {
                    NewsContentActivity.actionStart(parent.context, news.title, news.content)
                }
            }
            return holder
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val news = newsList[position]
            holder.newsTitle.text = news.title
        }

        override fun getItemCount() = newsList.size
    }
}