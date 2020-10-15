package com.example.payo.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.payo.DataModel.MainData
import com.example.payo.R
import kotlinx.android.synthetic.main.list_item_view.view.*

class HomeAdapter(var list: List<MainData>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(item: MainData) = with(itemView){
            val name = item.firstName + " " + item.lastName

            username.text = name
            email.text = item.email
            Glide.with(context).load(item.avatar).into(avatar)
        }
    }
}