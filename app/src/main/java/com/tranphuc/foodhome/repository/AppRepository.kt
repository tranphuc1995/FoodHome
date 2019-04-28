package com.tranphuc.foodhome.repository

import com.tranphuc.foodhome.R
import com.tranphuc.foodhome.repository.entities.*
import com.tranphuc.foodhome.repository.entities.Collection

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

    public fun createDataListItemFood(): MutableList<ItemFood> {
        var listItemFood: MutableList<ItemFood> = ArrayList()
        var listContent: MutableList<Content> = ArrayList()
        var titleHeader: ItemFood.TitleHeader = ItemFood.TitleHeader("Dùng ưu đãi - Hoàn tiền ngay", true)

        // add header viewpager
        var listImageViewPagerHeader: MutableList<Int> = ArrayList()
        for (i in (0..4)) {
            listImageViewPagerHeader.add(R.drawable.image_test)
        }
        listItemFood.add(
            ItemFood(
                TypeItemFood.HEADER_VIEWPAGER,
                4,
                titleHeader,
                "Demo",
                R.drawable.ic_food,
                listImageViewPagerHeader,
                listContent
            )
        )
        // add title
        var itemFoodTitle: ItemFood =
            ItemFood(TypeItemFood.TITLE, 4, titleHeader, "", -1, listImageViewPagerHeader, listContent)
        listItemFood.add(itemFoodTitle)

        // add grid
        for (i in (0..7)) {
            listItemFood.add(
                ItemFood(
                    TypeItemFood.GRID4,
                    1,
                    titleHeader,
                    "Demo",
                    R.drawable.ic_food,
                    listImageViewPagerHeader,
                    listContent
                )
            )
        }

        // add list horizontal
        for (j in (0..5)) {
            listContent.add(Content(R.drawable.ic_food, "Demo", R.drawable.image_landscape))
        }

        for (i in (0..9)) {
            listItemFood.add(
                ItemFood(
                    TypeItemFood.LIST_HORIZONTAL,
                    4,
                    titleHeader,
                    "Demo",
                    R.drawable.ic_food,
                    listImageViewPagerHeader,
                    listContent
                )
            )
        }
        return listItemFood
    }
}