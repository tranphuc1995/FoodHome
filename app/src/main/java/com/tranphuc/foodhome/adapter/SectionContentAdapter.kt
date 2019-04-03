package com.tranphuc.foodhome.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tranphuc.foodhome.R
import com.tranphuc.foodhome.repository.entities.Content
import com.tranphuc.foodhome.repository.entities.SectionContent
import kotlinx.android.synthetic.main.fragment_section_collection.view.*

class SectionContentAdapter(var listSectionContent: MutableList<SectionContent>, var context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    init {
        listSectionContent = ArrayList()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(p0.context).inflate(R.layout.fragment_section_collection, p0, false)
        return SectionContentViewHolder(view)
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        (p0 as SectionContentViewHolder).bindData(listSectionContent.get(p1), context, RecyclerView.RecycledViewPool())
    }

    override fun getItemCount(): Int {
        return listSectionContent.size
    }


    private class SectionContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var mContentAdapter: ContentAdapter
        fun bindData(sectionContent: SectionContent, context: Context, viewPool: RecyclerView.RecycledViewPool) {
            itemView.tvTitle.text = sectionContent.title
            itemView.rvSectionCollection.setRecycledViewPool(viewPool)
            initalizeRvContent(context)
            for (i in (0..sectionContent.listContent.size - 1)) {
                mContentAdapter.listContent.add(sectionContent.listContent.get(i))
                mContentAdapter.notifyItemInserted(mContentAdapter.itemCount - 1)
            }
        }

        private fun initalizeRvContent(context: Context) {
            var listContent: MutableList<Content> = ArrayList()
            itemView.rvSectionCollection.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            mContentAdapter = ContentAdapter(listContent, context)
            itemView.rvSectionCollection.adapter = mContentAdapter
        }
    }
}