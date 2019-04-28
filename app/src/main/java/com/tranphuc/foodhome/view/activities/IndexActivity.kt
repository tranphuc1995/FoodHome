package com.tranphuc.foodhome.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tranphuc.foodhome.R
import kotlinx.android.synthetic.main.activity_index.*

class IndexActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        btnScrollView.setOnClickListener {
            startActivity(Intent(this, NestedScrollViewActivity::class.java))
        }

        btnRecyclerView.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }

    }
}
