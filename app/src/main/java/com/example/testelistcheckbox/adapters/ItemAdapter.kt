package com.example.testelistcheckbox.adapters

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.testelistcheckbox.R
import com.example.testelistcheckbox.helpers.CustomFragment
import com.example.testelistcheckbox.itemlist.ItemList

class ItemAdapter(activity: Activity, listItens:
                  MutableList<ItemList> = mutableListOf(),
                  private var onClickItem : () -> Unit,
                  private var linearLayout: LinearLayout
                 ):
    AbstractRecyclerAdapter<ItemList, ItemAdapter.ViewHolder>(activity, R.layout.itemlist) {
    var customFragment = CustomFragment(activity)

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
                customFragment.recyclerFragment(activity, item.listaItens!!.toMutableList(), onClickParameter = {onClickItem}, linearLayout)
            }
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textItem : TextView = itemView.findViewById(R.id.textItem)
        val checkBox : CheckBox = itemView.findViewById(R.id.checkBox)
        val arrowDown : ImageButton = itemView.findViewById(R.id.imageViewItem)
    }
}