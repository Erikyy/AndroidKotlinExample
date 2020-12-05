package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.User

class UserAdapter(private val context: Context?, private val users : ArrayList<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater =  LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users.get(position)
        holder.name?.text = user.name
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class UserViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView? = null

        init {
            name = view.findViewById(R.id.username)
        }
    }
}