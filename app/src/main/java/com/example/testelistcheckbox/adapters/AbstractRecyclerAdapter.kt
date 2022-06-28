package com.example.testelistcheckbox.adapters

import android.app.Activity
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Rafael Suzin on 23/03/2018.
 */
abstract class AbstractRecyclerAdapter<T, K : RecyclerView.ViewHolder>(
    val activity: Activity,
    @LayoutRes private val resource: Int,
    var onClick: OnClick<T>? = null,
    var onClickCheckBox : OnCickCheckBox<T>? = null
) : RecyclerView.Adapter<K>() {

    var itens = mutableListOf<T>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    val isOnClickNoNull: Boolean
        get() = onClick != null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): K {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(resource, parent, false)
        return getViewHolder(contactView)
    }

    abstract fun getViewHolder(view: View): K

    protected fun isVisible(view: View, visible: Boolean): Boolean {
        view.visibility = if (visible) View.VISIBLE else View.GONE
        return visible
    }

    abstract fun onBindItemViewHolder(viewHolder: K, item: T, position: Int)
    override fun onBindViewHolder(holder: K, position: Int) {
        val item = itens[position]
        onBindItemViewHolder(holder, item, position)
        holder.itemView.setOnClickListener { onClick?.onClick(holder.itemView, item, position) }
    }

    override fun getItemCount(): Int {
        return itens.size
    }



    fun getString(@StringRes resource: Int): String {
        return activity.getString(resource)
    }

    protected fun setItemBackgroundColor(textView: View, @ColorInt color: Int) {
        when (val background = textView.background) {
            is ShapeDrawable -> background.paint.color = color
            is GradientDrawable -> background.setColor(color)
            is ColorDrawable -> background.color = color
        }
    }

    interface OnClick<T> {
        fun onClick(view: View?, item: T, position: Int)
    }

    interface OnCickCheckBox<T>{
        fun onClickCheckBox(view: View?,item :T, position: Int)
    }
}