package com.example.retrofitkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UsersAdapter (val users: List<User>): RecyclerView.Adapter<UsersAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun binData(users: User){



            val fn = itemView.findViewById<TextView>(R.id.firstName)
            val ln = itemView.findViewById<TextView>(R.id.lastName)
            val wb = itemView.findViewById<TextView>(R.id.website)

            fn.text = users.firstName
            ln.text = users.lastName
            wb.text = users.website
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData(users[position])
    }

}