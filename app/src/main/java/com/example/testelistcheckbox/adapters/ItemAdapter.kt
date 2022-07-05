package com.example.testelistcheckbox.adapters

import android.app.Activity
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.testelistcheckbox.R
import com.example.testelistcheckbox.itemlist.ProdutoFamilia
import kotlinx.android.synthetic.main.itemlist.view.*

class ItemAdapter(
    private val activity: Activity,
    private val listItens: MutableList<ProdutoFamilia> = mutableListOf(),
    onClick: OnClick<ProdutoFamilia>,
) :
    AbstractRecyclerAdapter<ProdutoFamilia, ItemAdapter.ViewHolder>(activity, R.layout.itemlist) {

    var valorPai  = arrayOf<Int>()
    var valorFilho = arrayOf<Int>()


    init {
        this.onClick = onClick
        itens = listItens
    }

    override fun getViewHolder(view: View): ViewHolder {
        return ViewHolder(view)
    }

    override fun onBindItemViewHolder(
        viewHolder: ViewHolder,
        item: ProdutoFamilia,
        position: Int
    ) {
        viewHolder.textItem.text = item.name
        viewHolder.checkBox.isChecked = item.isChecked
        adicionarId(item.nomePai, item)
        viewHolder.checkBox.setOnClickListener {
            item.isChecked = viewHolder.checkBox.isChecked
            checaItens(item.itensList, item.isChecked)
            notifyDataSetChanged()
        }
    }

    fun checaItens(itens :List<ProdutoFamilia>?, isChecked : Boolean): List<ProdutoFamilia>? {
        if(itens.isNullOrEmpty()){
            return null
        }
        itens?.forEach { item ->
            item.isChecked = isChecked
            checaItens(item.itensList?: listOf(), isChecked)
        }
        return itens
    }

    fun adicionarId(idParent: Double?, item: ProdutoFamilia){
        var valorInicialPai = 0
        for (i in valorPai){
            valorPai[i] = valorInicialPai++
            if(idParent == null){
                item.nomePai = valorPai[i].toDouble()
            }else {
                item.nomePai = idParent.toDouble()
            }
            for (j in valorFilho){
                   item.itensList?.forEach {
                       it.ehFilhoDe = item.nomePai + ((item.nomePai + 1) / 10)
                   }
            }
        }

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textItem: TextView = itemView.findViewById(R.id.textItem)
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
    }
}