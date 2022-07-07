package com.example.testelistcheckbox.itemlist

data class ProdutoFamilia(
    var familia : String = "",
    var name: String = "",
    var isChecked: Boolean = false,
    var itensList: List<ProdutoFamilia>? = null,
    var isExpanded: Boolean = false,
    var increment :String = "",
)
