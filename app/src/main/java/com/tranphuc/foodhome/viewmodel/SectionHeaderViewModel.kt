package com.tranphuc.foodhome.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tranphuc.foodhome.repository.AppRepository

class SectionHeaderViewModel(application: Application) : AndroidViewModel(application) {
    private var mListHeader: MutableLiveData<List<Int>> = MutableLiveData()

    public fun getListHeader(): LiveData<List<Int>> {
        return mListHeader
    }

    public fun getDataListHeader() {
        mListHeader.value = AppRepository!!.getInstance()!!.createDataListHeader()
    }
}