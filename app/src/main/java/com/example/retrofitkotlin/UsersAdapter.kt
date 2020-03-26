package com.example.retrofitkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UsersAdapter (private val users: List<User>): RecyclerView.Adapter<UsersAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun binData(users: User){

            val fn = itemView.findViewById<TextView>(R.id.firstName)
            val ln = itemView.findViewById<TextView>(R.id.userName)
            val wb = itemView.findViewById<TextView>(R.id.website)
            val img = itemView.findViewById<ImageView>(R.id.image)

            fn.text = users.name
            ln.text = users.username
            wb.text = users.email

            Glide.with(itemView)
                .load("https://images.pexels.com/photos/3610168/pexels-photo-3610168.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940").into(img)
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