package com.example.testelistcheckbox.adapters

import android.app.Activity
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.testelistcheckbox.R
import com.example.testelistcheckbox.itemlist.ItemList

class ItemAdapter(activity: Activity, listItens:
                  MutableList<ItemList> = mutableListOf(),
                  onClick: AbstractRecyclerAdapter.OnClick<ItemList>,
                 ):
    AbstractRecyclerAdapter<ItemList, ItemAdapter.ViewHolder>(activity, R.layout.itemlist) {

    init {
        this.onClick = onClick
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
       viewHolder.textItem.text = item.name
        viewHolder.checkBox.setOnClickListener {
            viewHolder.checkBox.isChecked != viewHolder.checkBox.isChecked
        }
        if(item.isExpanded == false){
//            viewHolder.itemView.visibility =  View.GONE
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textItem : TextView = itemView.findViewById(R.id.textItem)
        val checkBox : CheckBox = itemView.findViewById(R.id.checkBox)
        val arrowDown : ImageButton = itemView.findViewById(R.id.imageViewItem)
    }
}