package com.tranphuc.foodhome.adapter

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tranphuc.foodhome.R
import com.tranphuc.foodhome.repository.entities.Content
import com.tranphuc.foodhome.repository.entities.ItemFood
import com.tranphuc.foodhome.repository.entities.TypeItemFood
import kotlinx.android.synthetic.main.fragment_section_collection.view.*
import kotlinx.android.synthetic.main.fragment_section_header.view.*
import kotlinx.android.synthetic.main.item_title_header.view.*
import kotlinx.android.synthetic.main.item_use_voucher_get_refund.view.*

class ListFoodAdapter(var listItemFood: MutableList<ItemFood>, var context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return listItemFood.get(position).typeItemFood.type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TypeItemFood.HEADER_VIEWPAGER.type -> {
                var view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_section_header, parent, false)
                return ListFoodAdapter.ViewPgaerHeaderViewHolder(view)
            }

            TypeItemFood.TITLE.type -> {
                var view = LayoutInflater.from(parent.context).inflate(R.layout.item_title_header, parent, false)
                return ListFoodAdapter.TitleViewHolder(view)
            }

            TypeItemFood.GRID4.type -> {
                var view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_use_voucher_get_refund, parent, false)
                return ListFoodAdapter.UseVoucherGetRefundViewHolder(view)
            }

            TypeItemFood.LIST_HORIZONTAL.type -> {
                var view =
                    LayoutInflater.from(parent.context).inflate(R.layout.fragment_section_collection, parent, false)
                return ListFoodAdapter.CollectionViewHolder(view)
            }

            else -> {
                var view = LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false)
                return ListFoodAdapter.UseVoucherGetRefundViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return listItemFood.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            TypeItemFood.TITLE.type -> {
                (holder as TitleViewHolder).bindData(listItemFood.get(position))
            }

            TypeItemFood.GRID4.type -> {
                (holder as UseVoucherGetRefundViewHolder).bindData(listItemFood.get(position), context)
            }

            TypeItemFood.HEADER_VIEWPAGER.type -> {
                (holder as ViewPgaerHeaderViewHolder).bindData(listItemFood.get(position), context)
            }

            TypeItemFood.LIST_HORIZONTAL.type -> {
                (holder as CollectionViewHolder).bindData(listItemFood.get(position), context)
            }
        }
    }

    // ViewHolder
    private class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(itemFood: ItemFood) {
            itemView.tvTitleHeader.text = itemFood.titleHeader.title
            if (itemFood.titleHeader.isTitleCenter) {
                itemView.tvTitleHeader.gravity = Gravity.CENTER
            }
        }
    }

    private class UseVoucherGetRefundViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(itemFood: ItemFood, context: Context) {
            itemView.tvTitleCategory.text = itemFood.titleFood
            Glide.with(context).load(itemFood.iconFood).into(itemView.ivIconFood)
        }
    }

    private class ViewPgaerHeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var mImageSlidePagerAdapter: ImageSlidePagerAdapter

        fun bindData(itemFood: ItemFood, context: Context) {
            initializeVpHeader(context)
            mImageSlidePagerAdapter.listImage = itemFood.listImageViewPagerHeader
            mImageSlidePagerAdapter.notifyDataSetChanged()
            itemView.ciIndicatorHeader.setViewPager(itemView.vpHeader)
        }

        private fun initializeVpHeader(context: Context) {
            var listImage: MutableList<Int> = ArrayList()
            mImageSlidePagerAdapter = ImageSlidePagerAdapter(context, listImage)
            itemView.vpHeader.adapter = mImageSlidePagerAdapter

        }
    }

    private class CollectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var mContentAdapter: ContentAdapter

        fun bindData(itemFood: ItemFood, context: Context) {
            initRvCollection(context);
            mContentAdapter.listContent = itemFood.listContent
            mContentAdapter.notifyDataSetChanged()
        }

        private fun initRvCollection(context: Context) {
            var listContent: MutableList<Content> = ArrayList()
            itemView.rvSectionCollection.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            mContentAdapter = ContentAdapter(listContent, context)
            itemView.rvSectionCollection.adapter = mContentAdapter
        }

    }
}