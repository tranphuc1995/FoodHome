package com.tranphuc.foodhome.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tranphuc.foodhome.R
import com.tranphuc.foodhome.repository.entities.Collection
import kotlinx.android.synthetic.main.item_collection.view.*

class CollectionAdapter(var listCollection: MutableList<Collection>, var context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    init {
        listCollection = ArrayList()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(p0.context).inflate(R.layout.item_collection, p0, false)
        return CollectionViewHolder(view)
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        (p0 as CollectionViewHolder).bindData(listCollection.get(p1), context)
    }

    override fun getItemCount(): Int {
        return listCollection.size
    }


    private class CollectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(collection: Collection, context: Context) {
            itemView.tvTitle.text = collection.title
            Glide.with(context).load(collection.image).into(itemView.ivImageFood)
        }
    }
}