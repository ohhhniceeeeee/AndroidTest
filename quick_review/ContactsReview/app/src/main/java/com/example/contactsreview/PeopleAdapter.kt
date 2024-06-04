package com.example.contactsreview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PeopleAdapter(val peopleList: List<People>) :
    RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val peopleName: TextView = view.findViewById(R.id.peopleName)
        val peopleNumber: TextView = view.findViewById(R.id.peopleNumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_people, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.peopleName.setOnClickListener {
            val position = viewHolder.bindingAdapterPosition
            val people = peopleList[position]
            Toast.makeText(
                parent.context,
                "You Clicked ${people.name}'s name:${people.name}",
                Toast.LENGTH_SHORT
            ).show()
        }
        viewHolder.peopleNumber.setOnClickListener {
            val position = viewHolder.bindingAdapterPosition
            val people = peopleList[position]
            Toast.makeText(
                parent.context,
                "You clicked ${people.name}'s phone number: ${people.phoneNumber}",
                Toast.LENGTH_SHORT
            ).show()
        }
        return viewHolder
    }

    override fun getItemCount() = peopleList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val people = peopleList[position]
        holder.peopleName.text = people.name
        holder.peopleNumber.text = people.phoneNumber
    }
}