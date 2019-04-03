package com.tranphuc.foodhome.repository

import com.tranphuc.foodhome.R
import com.tranphuc.foodhome.repository.entities.Collection
import com.tranphuc.foodhome.repository.entities.Content
import com.tranphuc.foodhome.repository.entities.SectionContent

class AppRepository {
    companion object {
        private var sInstance: AppRepository? = null
        public fun getInstance(): AppRepository? {
            if (sInstance == null) {
                synchronized(AppRepository::class.java) {
                    sInstance = AppRepository()
                }
            }
            return sInstance
        }
    }

    public fun createDataCollection(): MutableList<Collection> {
        var listCollection: MutableList<Collection> = ArrayList()
        for (i in (0..10)) {
            listCollection.add(Collection(R.drawable.image_test, "demo"))
        }
        return listCollection
    }

    public fun createDataUseVoucherGetRefund(): MutableList<Collection> {
        var listCollection: MutableList<Collection> = ArrayList()
        for (i in (0..7)) {
            listCollection.add(Collection(R.drawable.ic_food, "Trà sữa"))
        }
        return listCollection
    }

    public fun createDataListSectionContent(): MutableList<SectionContent> {
        var listSectionContent: MutableList<SectionContent> = ArrayList()
        for (i in (0..9)) {
            var listContent: MutableList<Content> = ArrayList()
            for (j in (0..5)) {
                listContent.add(Content(R.drawable.ic_food, "Demo", R.drawable.image_landscape))
            }
            listSectionContent.add(SectionContent("Ẩm thực", listContent))
        }
        return listSectionContent
    }

    public fun createDataListHeader(): MutableList<Int> {
        var listHeader: MutableList<Int> = ArrayList()
        for (i in (0..4)) {
            listHeader.add(R.drawable.image_test)
        }
        return listHeader
    }
}