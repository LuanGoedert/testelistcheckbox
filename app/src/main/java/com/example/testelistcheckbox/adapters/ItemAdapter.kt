package com.example.testelistcheckbox.adapters

import android.app.Activity
import android.view.View
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.testelistcheckbox.R
import com.example.testelistcheckbox.itemlist.ProdutoFamilia
import kotlinx.android.synthetic.main.itemlist.view.*
import kotlin.random.Random

class ItemAdapter(
    private val activity: Activity,
    private val listItens: MutableList<ProdutoFamilia> = mutableListOf(),
    onClick: OnClick<ProdutoFamilia>,
) :
    AbstractRecyclerAdapter<ProdutoFamilia, ItemAdapter.ViewHolder>(activity, R.layout.itemlist) {
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
        if (item.increment.isNullOrEmpty()) {

            item.increment = "   "
        }
        else {
          when(item.increment.length){
              3 ->{
                  viewHolder.traco.setBackgroundColor(activity.getColor(R.color.color1))
              }
              6 ->{
                  viewHolder.traco.setBackgroundColor(activity.getColor(R.color.color2))
              }
              9 ->{
                    viewHolder.traco.setBackgroundColor(activity.getColor(R.color.color3))
              }
              12 ->{
                  viewHolder.traco.setBackgroundColor(activity.getColor(R.color.color4))
              }
              15 ->{
                  viewHolder.traco.setBackgroundColor(activity.getColor(R.color.color5))
              }
          }
        }

        viewHolder.traco.text = item.increment
        viewHolder.checkBox.setOnClickListener {
            item.isChecked = viewHolder.checkBox.isChecked
            checaItens(item.itensList, item.isChecked, item.increment)
            notifyDataSetChanged()
        }
    }

    fun checaItens(
        itens: List<ProdutoFamilia>?,
        isChecked: Boolean,
        itemIncrement: String
    ): List<ProdutoFamilia>? {
        if (itens.isNullOrEmpty()) {
            return null
        }
        itens?.forEach { item ->

            item.isChecked = isChecked
            item.increment =  itemIncrement + "   "
            checaItens(item.itensList ?: listOf(), isChecked, item.increment)
        }
        return itens
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textItem: TextView = itemView.findViewById(R.id.textItem)
        val traco: TextView = itemView.findViewById(R.id.traco)
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
    }
}