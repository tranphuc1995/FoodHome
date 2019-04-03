package com.tranphuc.foodhome.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tranphuc.foodhome.R
import com.tranphuc.foodhome.adapter.SectionContentAdapter
import com.tranphuc.foodhome.repository.entities.SectionContent
import com.tranphuc.foodhome.viewmodel.SectionContentViewModel
import kotlinx.android.synthetic.main.fragment_section_content.view.*

class SectionContentFragment : Fragment() {

    private lateinit var mView: View
    private lateinit var mSectionContentAdapter: SectionContentAdapter
    private lateinit var mSectionContentViewModel: SectionContentViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = LayoutInflater.from(activity).inflate(R.layout.fragment_section_content, container, false)
        initializeView()
        addObserve()
        return mView
    }

    private fun addObserve() {
        mSectionContentViewModel.getListSectionContent().observe(requireActivity(), Observer { listSectionContent ->
            for (i in (0..listSectionContent.size - 1)) {
                mSectionContentAdapter.listSectionContent.add(listSectionContent.get(i))
                mSectionContentAdapter.notifyItemInserted(mSectionContentAdapter.itemCount - 1)
            }
        })
    }

    private fun initializeView() {
        mSectionContentViewModel = ViewModelProviders.of(requireActivity()).get(SectionContentViewModel::class.java)
        initializeRvSectionContent()
        mSectionContentViewModel.getDataListSectionContent()
    }


    private fun initializeRvSectionContent() {
        var listSectionContent: MutableList<SectionContent> = ArrayList()
        mView.rvSectionContent.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        mSectionContentAdapter = SectionContentAdapter(listSectionContent, requireActivity())
        mView.rvSectionContent.adapter = mSectionContentAdapter
    }
}