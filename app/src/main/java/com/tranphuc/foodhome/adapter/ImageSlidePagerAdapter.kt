package com.tranphuc.foodhome.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.tranphuc.foodhome.R
import kotlinx.android.synthetic.main.item_header.view.*

class ImageSlidePagerAdapter(var context: Context, var listImage: MutableList<Int>) : PagerAdapter() {


    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 == p1
    }

    override fun getCount(): Int {
        return listImage.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view = LayoutInflater.from(context).inflate(R.layout.item_header, container, false)
        Glide.with(context).load(listImage.get(position)).into(view.ivHeader)
        container.addView(view, 0)
        return view

    }

}