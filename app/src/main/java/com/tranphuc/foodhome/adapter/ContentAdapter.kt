package com.tranphuc.foodhome.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tranphuc.foodhome.R
import com.tranphuc.foodhome.repository.entities.Content
import kotlinx.android.synthetic.main.item_content.view.*

class ContentAdapter(var listContent: MutableList<Content>, var context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    init {
        listContent = ArrayList()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(p0.context).inflate(R.layout.item_content, p0, false)
        return ContentViewHolder(view)
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        (p0 as ContentViewHolder).bindData(listContent.get(p1), context)
        p0.itemView.setOnClickListener { Toast.makeText(context,""+p1,Toast.LENGTH_SHORT).show() }
    }

    override fun getItemCount(): Int {
        return listContent.size
    }


    private class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(content: Content, context: Context) {
            itemView.tvTitleContent.text = content.title
            Glide.with(context).load(content.demoImage).into(itemView.ivDemoImage)
            Glide.with(context).load(content.brandIcon).into(itemView.civFoodIcon)
        }
    }
}