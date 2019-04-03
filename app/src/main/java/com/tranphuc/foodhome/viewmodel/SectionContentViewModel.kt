package com.tranphuc.foodhome.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tranphuc.foodhome.repository.AppRepository
import com.tranphuc.foodhome.repository.entities.SectionContent

class SectionContentViewModel(application: Application) : AndroidViewModel(application) {
    private var mListSectionContent: MutableLiveData<List<SectionContent>> = MutableLiveData()

    public fun getListSectionContent(): LiveData<List<SectionContent>> {
        return mListSectionContent
    }

    public fun getDataListSectionContent() {
        mListSectionContent.value = AppRepository.getInstance()!!.createDataListSectionContent()
    }
}