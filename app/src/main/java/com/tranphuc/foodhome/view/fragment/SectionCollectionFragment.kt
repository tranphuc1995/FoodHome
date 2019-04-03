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
import com.tranphuc.foodhome.adapter.CollectionAdapter
import com.tranphuc.foodhome.repository.entities.Collection
import com.tranphuc.foodhome.viewmodel.SectionCollectionViewModel
import kotlinx.android.synthetic.main.fragment_section_collection.view.*

class SectionCollectionFragment : Fragment() {

    private lateinit var mCollectionAdapter: CollectionAdapter
    private lateinit var mView: View
    private lateinit var mSectionCollectionViewModel: SectionCollectionViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = LayoutInflater.from(activity).inflate(R.layout.fragment_section_collection, container, false)
        initializeView()
        addObserve()
        return mView
    }

    private fun addObserve() {
        mSectionCollectionViewModel.getListCollection().observe(requireActivity(), Observer { listCollection ->
            for (i in (0..listCollection.size - 1)) {
                mCollectionAdapter.listCollection.add(listCollection.get(i))
                mCollectionAdapter.notifyItemInserted(mCollectionAdapter.itemCount - 1)
            }
        })

    }

    private fun initializeView() {
        mSectionCollectionViewModel =
            ViewModelProviders.of(requireActivity()).get(SectionCollectionViewModel::class.java)
        initializeRvCollection()
        mSectionCollectionViewModel.getDataListCollection()
    }


    private fun initializeRvCollection() {
        var listCollection: MutableList<Collection> = ArrayList()
        mView.rvSectionCollection.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
        mCollectionAdapter = CollectionAdapter(listCollection, requireActivity())
        mView.rvSectionCollection.adapter = mCollectionAdapter
    }

}