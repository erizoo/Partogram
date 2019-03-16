package com.boiko.app.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.boiko.app.R
import com.boiko.app.base.BaseRecyclerViewAdapter
import kotlinx.android.synthetic.main.list_items_add_parametrs.view.*

class ParametersAdapter(items: List<String>) : BaseRecyclerViewAdapter<ParametersAdapter.ViewHolder>() {

    private lateinit var callback: ParametersAdapter.Callback

    override var items: List<String> = items
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_items_add_parametrs, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(items[position])
        holder.itemView.isClickable = false
    }

    fun setCallback(callback: Callback) {
        this.callback = callback
    }

    interface Callback {

        fun openParameter(type: String)

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: String) {
            itemView.title.text = item
            itemView.title.setOnClickListener {
                callback.openParameter(item)
            }
        }
    }
}