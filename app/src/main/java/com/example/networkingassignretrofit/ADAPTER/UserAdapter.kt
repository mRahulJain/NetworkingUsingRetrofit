package com.example.networkingassignretrofit

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.users_item.view.*

class UserAdapter(val nameList : List<Users>) : RecyclerView.Adapter<UserAdapter.NameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val li = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = li.inflate(R.layout.users_item, parent, false)
        return NameViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    override fun onBindViewHolder(holder: UserAdapter.NameViewHolder, position: Int) {
        val names = nameList[position]
        holder.itemView.num.text = names.id.toString()
        holder.itemView.name.text = names.name
        holder.itemView.username.text = names.username
        holder.itemView.email.text = names.email

        holder.itemView.setOnClickListener {
            Log.i("TAG", "CLICKED $position")
        }
    }


    class NameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}