package com.tranphuc.foodhome.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tranphuc.foodhome.R
import com.tranphuc.foodhome.adapter.ImageSlidePagerAdapter
import com.tranphuc.foodhome.viewmodel.SectionHeaderViewModel
import kotlinx.android.synthetic.main.fragment_section_header.view.*

class SectionHeaderFragment : Fragment() {
    private lateinit var mView: View
    private lateinit var mImageSlidePagerAdapter: ImageSlidePagerAdapter
    private lateinit var mSectionHeaderViewModel: SectionHeaderViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = LayoutInflater.from(activity).inflate(R.layout.fragment_section_header, container, false)
        initializeView()
        addObserve()
        return mView
    }

    private fun addObserve() {
        mSectionHeaderViewModel.getListHeader().observe(requireActivity(), Observer { listImage ->
            mImageSlidePagerAdapter.listImage = listImage as MutableList<Int>
            mImageSlidePagerAdapter.notifyDataSetChanged()

            // set indicator for viewpager
            mView.ciIndicatorHeader.setViewPager(mView.vpHeader)

        })
    }

    private fun initializeView() {
        mSectionHeaderViewModel = ViewModelProviders.of(requireActivity()).get(SectionHeaderViewModel::class.java)
        initializeVpHeader()
        mSectionHeaderViewModel.getDataListHeader()
    }

    private fun initializeVpHeader() {
        var listImage: MutableList<Int> = ArrayList()
        mImageSlidePagerAdapter = ImageSlidePagerAdapter(requireActivity(), listImage)
        mView.vpHeader.adapter = mImageSlidePagerAdapter

    }
}