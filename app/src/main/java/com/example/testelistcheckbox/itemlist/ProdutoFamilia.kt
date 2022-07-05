package com.example.testelistcheckbox.itemlist

data class ProdutoFamilia(
    var familia : String = "",
    var name: String = "",
    var isChecked: Boolean = false,
    var itensList: List<ProdutoFamilia>? = null,
    var isExpanded: Boolean = false,
    var ehFilhoDe : Double = 0.0,
    var nomePai : Double = 0.0
)
