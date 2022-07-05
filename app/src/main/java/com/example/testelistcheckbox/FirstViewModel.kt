package com.example.testelistcheckbox

import androidx.lifecycle.ViewModel
import com.example.testelistcheckbox.itemlist.ProdutoFamilia

class FirstViewModel : ViewModel() {


    var mapProdutos: MutableMap<String, ItemData> = mutableMapOf()

    fun atribuiListaToMap(listaProdutos: List<ProdutoFamilia>?) {
        listaProdutos?.forEach {
            mapProdutos[it.nome] = ItemData(it.isExpanded, it, it.nome)
            atribuiListaToMap(it.itensList?.toMutableList())
        }
    }

    fun hideList(itensList: List<ProdutoFamilia>?) {
        itensList?.forEach { item ->
            removeItemsFromMap(item.nome)
            hideList(item.itensList)
        }
    }

    fun removeItemsFromMap(itemToRemove: String) {
        mapProdutos.remove(itemToRemove)
    }

    data class ItemData(
        var isExPanded: Boolean = false,
        var produtoFamilia: ProdutoFamilia? = null,
        var childOF: String = ""
    )
}