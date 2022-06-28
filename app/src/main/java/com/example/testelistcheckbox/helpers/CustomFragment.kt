package com.example.testelistcheckbox.helpers

import android.app.Activity
import android.app.AlertDialog
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testelistcheckbox.R
import com.example.testelistcheckbox.adapters.AbstractRecyclerAdapter
import com.example.testelistcheckbox.adapters.ItemAdapter
import kotlinx.android.synthetic.main.fragment_recycler.view.recycleritem
import com.example.testelistcheckbox.itemlist.ItemList

class CustomFragment(val activity: Activity) {

    private lateinit var itemAdapter: ItemAdapter

    private var dialog: AlertDialog? = null

    fun recyclerFragment(
        activity: Activity,
        listItens: MutableList<ItemList>?,
        onClickParameter: () -> Unit
    ) {
        if (listItens.isNullOrEmpty()) {
            return
        }
        val inflater = activity.layoutInflater
        val dialogView = inflater.inflate(R.layout.fragment_recycler, null)
        val builder = AlertDialog.Builder(activity)
        builder.setView(dialogView)
        itemAdapter = ItemAdapter(
            activity,
            listItens,
            onClickParameter)
        dialogView.recycleritem.layoutManager = LinearLayoutManager(activity)
        dialogView.recycleritem.adapter = itemAdapter
        builder.setView(dialogView)
        builder.setCancelable(false)
        dialog = builder.create()
        dialog!!.show()
        itemAdapter.notifyDataSetChanged()
    }

    fun dismiss() {
        dialog?.dismiss()
    }
}