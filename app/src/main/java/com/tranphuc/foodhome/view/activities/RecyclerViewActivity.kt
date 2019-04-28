package com.tranphuc.foodhome.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.tranphuc.foodhome.R
import com.tranphuc.foodhome.adapter.ListFoodAdapter
import com.tranphuc.foodhome.repository.entities.ItemFood
import com.tranphuc.foodhome.viewmodel.RecyclerViewViewModel
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var mRecyclerViewViewModel: RecyclerViewViewModel
    private lateinit var mListFoodAdapter: ListFoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        mRecyclerViewViewModel = ViewModelProviders.of(this).get(RecyclerViewViewModel::class.java)

        initializeView()
        addObserve()

        mRecyclerViewViewModel.getDataListItemFood()
    }

    private fun initializeView() {
        initializeRvListFood()
    }

    private fun initializeRvListFood() {
        var listFood: MutableList<ItemFood> = ArrayList()
        mListFoodAdapter = ListFoodAdapter(listFood, this)
        var gridLayoutManager = GridLayoutManager(this, 4)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return mListFoodAdapter.listItemFood.get(position).space
            }
        }
        rvListFood.layoutManager = gridLayoutManager
        rvListFood.adapter = mListFoodAdapter
    }

    private fun addObserve() {
        mRecyclerViewViewModel.getListItemFood().observe(this, Observer { listItemFood ->
            for (i in (0..listItemFood.size - 1)) {
                mListFoodAdapter.listItemFood.add(listItemFood.get(i))
                mListFoodAdapter.notifyItemInserted(mListFoodAdapter.itemCount - 1)
            }
        })
    }
}
