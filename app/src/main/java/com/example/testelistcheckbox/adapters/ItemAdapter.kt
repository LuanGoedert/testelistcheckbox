package com.example.testelistcheckbox.adapters

import android.app.Activity
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.testelistcheckbox.R
import com.example.testelistcheckbox.itemlist.ProdutoFamilia

class ItemAdapter(activity: Activity, listItens:
                  MutableList<ProdutoFamilia> = mutableListOf(),
                  onClick: AbstractRecyclerAdapter.OnClick<ProdutoFamilia>,
                 ):
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
        if(item.isChecked){
            viewHolder.checkBox.isChecked = item.isChecked
        }
       viewHolder.textItem.text = item.name

        viewHolder.checkBox.setOnClickListener {
            item.isChecked = viewHolder.checkBox.isChecked
            if (item.isChecked && !item.itensList.isNullOrEmpty()){
                item.itensList!!.forEach {
                    it.isChecked = item.isChecked
                }
            }
            notifyDataSetChanged()
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textItem : TextView = itemView.findViewById(R.id.textItem)
        var checkBox : CheckBox = itemView.findViewById(R.id.checkBox)
        val arrowDown : ImageButton = itemView.findViewById(R.id.imageViewItem)
    }
}