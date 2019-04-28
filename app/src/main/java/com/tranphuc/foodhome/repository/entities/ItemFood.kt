package com.tranphuc.foodhome.repository.entities

class ItemFood(
    var typeItemFood: TypeItemFood,
    var space: Int,
    var titleHeader: TitleHeader,
    var titleFood: String,
    var iconFood: Int,
    var listImageViewPagerHeader: MutableList<Int>,
    var listContent: MutableList<Content>
) {


    class TitleHeader(var title: String, var isTitleCenter: Boolean) {}
}