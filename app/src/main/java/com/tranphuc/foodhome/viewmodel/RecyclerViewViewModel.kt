package com.tranphuc.foodhome.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tranphuc.foodhome.repository.AppRepository
import com.tranphuc.foodhome.repository.entities.ItemFood

class RecyclerViewViewModel(application: Application) : AndroidViewModel(application) {
    private var mListItemFood: MutableLiveData<List<ItemFood>> = MutableLiveData()

    public fun getListItemFood(): LiveData<List<ItemFood>> {
        return mListItemFood
    }

    public fun getDataListItemFood() {
        mListItemFood.value = AppRepository.getInstance()!!.createDataListItemFood()
    }
}