package com.boiko.app.ui.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.boiko.app.R
import com.boiko.app.base.BaseRecyclerViewAdapter
import com.boiko.app.data.models.ResponseGoods
import kotlinx.android.synthetic.main.list_item_suppliers.view.*

class GoodsAdapter(items: List<ResponseGoods>) : BaseRecyclerViewAdapter<GoodsAdapter.ViewHolder>() {

    private lateinit var callback: Callback

    override var items: List<ResponseGoods> = items
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_suppliers, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(items[position])
    }

    fun setCallback(callback: Callback) {
        this.callback = callback
    }

    interface Callback {

        fun openParameter(type: Int)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(item: ResponseGoods) {
            itemView.title.text = item.name
            itemView.amount.text = item.amount
            if (item.sended) {
                itemView.title.setBackgroundColor(Color.YELLOW)
            }
        }
    }
}