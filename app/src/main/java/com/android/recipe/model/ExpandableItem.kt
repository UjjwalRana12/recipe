package com.android.recipe.model

data class ExpandableItem(
    val heading:String,
    val about:String,
    var isExpandable:Boolean = false
)
