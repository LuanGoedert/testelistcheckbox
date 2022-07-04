package com.example.testelistcheckbox

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testelistcheckbox.itemlist.ProdutoFamilia

class FirstViewModel: ViewModel() {

    val _listaProdutos = MutableLiveData<MutableList<ProdutoFamilia>>(mutableListOf())
    val listaProdutos : LiveData<MutableList<ProdutoFamilia>> = _listaProdutos


}