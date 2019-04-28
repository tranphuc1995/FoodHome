package com.tranphuc.foodhome.view.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import com.codemonkeylabs.fpslibrary.TinyDancer
import com.tranphuc.foodhome.R
import com.tranphuc.foodhome.view.fragment.SectionCollectionFragment
import com.tranphuc.foodhome.view.fragment.SectionContentFragment
import com.tranphuc.foodhome.view.fragment.SectionHeaderFragment
import com.tranphuc.foodhome.view.fragment.SectionUseVoucherGetRefundFragment



class NestedScrollViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_scrollview)
        //
        addFragment(R.id.flSectionHeader, SectionHeaderFragment())
        addFragment(R.id.flSectionUseVoucherGetRefund, SectionUseVoucherGetRefundFragment())
        addFragment(R.id.flSectionCollection, SectionCollectionFragment())
        addFragment(R.id.flSectionContent, SectionContentFragment())
/*

        nsMain.setOnScrollChangeListener(object : NestedScrollView.OnScrollChangeListener.OnScrollChangeListener {
            override fun onScrollChange(
                v: NestedScrollView?,
                scrollX: Int,
                scrollY: Int,
                oldScrollX: Int,
                oldScrollY: Int
            ) {

                if (scrollY > oldScrollY) {
                    Log.d("debug_phuc", "Scroll DOWN");
                }
                if (scrollY < oldScrollY) {
                    Log.d("debug_phuc", "Scroll UP");
                }

                if (scrollY == 0) {
                    Log.d("debug_phuc", "TOP SCROLL");
                }

                if (v!!.getChildAt(v.getChildCount() - 1) != null) {
                    if ((scrollY >= (v.getChildAt(v.getChildCount() - 1).getMeasuredHeight() - v.getMeasuredHeight())) &&
                        scrollY > oldScrollY
                    ) {
                        Log.d("debug_phuc", "BOTTOM SCROLL");
                    }

                }
            }
        })

*/

        TinyDancer.create()
            .show(this);
    }


    private fun addFragment(viewId: Int, fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .add(viewId, fragment)
            .commit()
    }
}
