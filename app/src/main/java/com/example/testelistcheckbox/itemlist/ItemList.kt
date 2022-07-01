package com.example.testelistcheckbox.itemlist

data class ItemList(
    var code : String  = "",
    var name : String = "",
    var itensList: List<ItemList>? = null,
    var childOf : String = "",
    var parent : Boolean = false,
    var child: Boolean = false,
    var isExpanded : Boolean = false
)