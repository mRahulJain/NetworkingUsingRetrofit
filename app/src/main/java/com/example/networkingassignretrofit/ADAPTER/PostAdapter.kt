package com.example.networkingassignretrofit.ADAPTER

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.networkingassignretrofit.DATA_CLASS.Posts
import com.example.networkingassignretrofit.R
import com.example.networkingassignretrofit.Todos
import kotlinx.android.synthetic.main.todos_item.view.*
import kotlinx.android.synthetic.main.users_item.view.num

class PostAdapter(val nameList : List<Posts>) : RecyclerView.Adapter<PostAdapter.NameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val li = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = li.inflate(R.layout.posts_item, parent, false)
        return NameViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    override fun onBindViewHolder(holder: PostAdapter.NameViewHolder, position: Int) {
        val names = nameList[position]
        holder.itemView.userID.text = names.userId.toString()
        holder.itemView.num.text = names.id.toString()
        holder.itemView.title.text = names.title

        holder.itemView.setOnClickListener {
            Log.i("TAG", "CLICKED $position")
        }
    }


    class NameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}