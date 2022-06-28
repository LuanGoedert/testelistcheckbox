package com.example.testelistcheckbox.helpers

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testelistcheckbox.R
import com.example.testelistcheckbox.adapters.AbstractRecyclerAdapter
import com.example.testelistcheckbox.adapters.ItemAdapter
import com.example.testelistcheckbox.itemlist.ItemList

class CustomFragment(val activity: Activity) {

    private lateinit var itemAdapter: ItemAdapter

    private var dialog =  Fragment()

    fun recyclerFragment(
        activity: Activity,
        listItens: MutableList<ItemList>?,
        onClickParameter: () -> Unit,
        linearLayout: LinearLayout
    ) {
        if (listItens.isNullOrEmpty()) {
            return
        }
        linearLayout.orientation = LinearLayout.VERTICAL
        val dialogView = RecyclerView(activity)
        attachItemAdapter(activity, listItens, onClickParameter, linearLayout)
        dialogView.layoutManager = LinearLayoutManager(activity)
        dialogView.adapter = itemAdapter

        linearLayout.addView(dialogView,  0)
        val inflater = activity.layoutInflater
        inflater.inflate(linearLayout.sourceLayoutResId, null)
        itemAdapter.notifyDataSetChanged()
    }

    private fun attachItemAdapter(
        activity: Activity,
        listItens: MutableList<ItemList>,
        onClickParameter: () -> Unit,
        linearLayout: LinearLayout
    ) {
        itemAdapter = ItemAdapter(
            activity,
            listItens,
            onClickParameter, linearLayout
        )
    }

    fun dismiss() {
//        dialog?.dismiss()
    }
}