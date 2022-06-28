package com.example.testelistcheckbox.adapters

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testelistcheckbox.R
import com.example.testelistcheckbox.itemlist.ItemList

class ItemAdapter(activity: Activity, listItens:
                  MutableList<ItemList> = mutableListOf(),
                  private var onClickItem : () -> Unit,
                 ):
    AbstractRecyclerAdapter<ItemList, ItemAdapter.ViewHolder>(activity, R.layout.itemlist) {

    init {
        itens = listItens
    }
    override fun getViewHolder(view: View): ViewHolder {
        return ViewHolder(view)
    }

    override fun onBindItemViewHolder(
        viewHolder: ViewHolder,
        item: ItemList,
        position: Int
    ) {
       viewHolder.textItem.text = item.nome
        viewHolder.checkBox.setOnClickListener {
            viewHolder.checkBox.isChecked != viewHolder.checkBox.isChecked
        }
        viewHolder.arrowDown.setOnClickListener{
            if(!item.listaItens.isNullOrEmpty()){
            }
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textItem : TextView = itemView.findViewById(R.id.textItem)
        val checkBox : CheckBox = itemView.findViewById(R.id.checkBox)
        val arrowDown : ImageView = itemView.findViewById(R.id.imageViewItem)
    }
}