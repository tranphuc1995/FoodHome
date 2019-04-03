package com.tranphuc.foodhome.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tranphuc.foodhome.repository.AppRepository
import com.tranphuc.foodhome.repository.entities.Collection

class SectionCollectionViewModel(application: Application) : AndroidViewModel(application) {
    private var mListCollection: MutableLiveData<List<Collection>> = MutableLiveData()

    public fun getListCollection(): LiveData<List<Collection>> {
        return mListCollection
    }

    public fun getDataListCollection() {
        mListCollection.value = AppRepository.getInstance()!!.createDataCollection()
    }

}