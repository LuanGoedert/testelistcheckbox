package com.example.testelistcheckbox.itemlist

data class ProdutoFamilia(
    var familia : String = "",
    var nome: String = "",
    var isChecked: Boolean = false,
    var itensList: List<ProdutoFamilia>? = null,
    var isExpanded: Boolean = false
)
