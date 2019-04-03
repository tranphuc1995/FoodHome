package com.tranphuc.foodhome.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tranphuc.foodhome.R
import com.tranphuc.foodhome.repository.entities.Collection
import kotlinx.android.synthetic.main.item_use_voucher_get_refund.view.*

class UseVoucherGetRefundAdapter(var listCollection: MutableList<Collection>, var context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    init {
        listCollection = ArrayList()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(p0.context).inflate(R.layout.item_use_voucher_get_refund, p0, false)
        return UseVoucherGetRefundViewHolder(view)
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        (p0 as UseVoucherGetRefundViewHolder).bindData(listCollection.get(p1), context)
    }

    override fun getItemCount(): Int {
        return listCollection.size
    }


    private class UseVoucherGetRefundViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(collection: Collection, context: Context) {
            itemView.tvTitleCategory.text = collection.title
            Glide.with(context).load(collection.image).into(itemView.ivIconFood)
        }
    }
}