package com.boiko.app.base

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.AdapterView
import com.boiko.app.R

abstract class BaseRecyclerViewAdapter<VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    private var onItemClickListener: OnItemClickListener = object : OnItemClickListener {
        override fun onItemClickListener(view: View, position: Int, item: Any?) {
            return
        }
    }

    internal abstract val items: List<*>?

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    override fun getItemCount(): Int {
        return if (items != null) items!!.size else 0
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setTag(R.string.key_position, position)
        holder.itemView.setOnClickListener { view -> onClickItem(view, view.getTag(R.string.key_position) as Int) }
    }

    protected fun onClickItem(view: View, position: Int) {
        onItemClickListener.onItemClickListener(view, position, items?.get(position))
    }
}
