package com.tranphuc.foodhome.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.tranphuc.foodhome.R
import com.tranphuc.foodhome.adapter.UseVoucherGetRefundAdapter
import com.tranphuc.foodhome.repository.entities.Collection
import com.tranphuc.foodhome.viewmodel.SectionUseVoucherGetRefundViewModel
import kotlinx.android.synthetic.main.fragment_section_use_voucher_get_refund.view.*

class SectionUseVoucherGetRefundFragment : Fragment() {

    private lateinit var mUseVoucherGetRefundAdapter: UseVoucherGetRefundAdapter
    private lateinit var mView: View
    private lateinit var mSectionUseVoucherGetRefundViewModel: SectionUseVoucherGetRefundViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView =
            LayoutInflater.from(activity).inflate(R.layout.fragment_section_use_voucher_get_refund, container, false)
        initializeView()
        addObserve()
        return mView
    }

    private fun addObserve() {
        mSectionUseVoucherGetRefundViewModel.getListCollection().observe(requireActivity(), Observer { listCollection ->
            for (i in (0..listCollection.size - 1)) {
                mUseVoucherGetRefundAdapter.listCollection.add(listCollection.get(i))
                mUseVoucherGetRefundAdapter.notifyItemInserted(mUseVoucherGetRefundAdapter.itemCount - 1)
            }
        })

    }

    private fun initializeView() {
        mSectionUseVoucherGetRefundViewModel =
            ViewModelProviders.of(requireActivity()).get(SectionUseVoucherGetRefundViewModel::class.java)
        initializeRvSectionUseVoucherGetRefund()
        mSectionUseVoucherGetRefundViewModel.getDataListUseVoucherGetRefund()
    }


    private fun initializeRvSectionUseVoucherGetRefund() {
        var listCollection: MutableList<Collection> = ArrayList()
        mView.rvSectionUseVoucherGetRefund.layoutManager = GridLayoutManager(context, 4)
        mUseVoucherGetRefundAdapter = UseVoucherGetRefundAdapter(listCollection, requireActivity())
        mView.rvSectionUseVoucherGetRefund.adapter = mUseVoucherGetRefundAdapter
    }

}