package com.example.testelistcheckbox.itemlist

data class ItemList(
    var codigo : String  = "",
    var nome : String = "",
    var listaItens: List<ItemList>? = null)