package com.boiko.app.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.boiko.app.R
import com.boiko.app.base.BaseRecyclerViewAdapter
import kotlinx.android.synthetic.main.list_item_labor_women.view.*

class LaborWomenAdapter(items: List<String>) : BaseRecyclerViewAdapter<LaborWomenAdapter.ViewHolder>() {

    private lateinit var callback: Callback

    override var items: List<String> = items
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_labor_women, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(items[position])
        holder.itemView.isClickable = false
    }

    private fun setCallback(callback: Callback){
        this.callback = callback
    }

    interface Callback{

        fun openParameter(type: String)

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: String) {
            itemView.name.text = "Меркель И.О.  AB(IV) Rh+"
            itemView.time_return.text = "Последнее изменение: 36 минут назад"
            itemView.time_begin.text = "Время начала:   12.01.2019 15:35"
            itemView.head.text = "Положение шейки матки и головки: 5/3 см"
            itemView.age.text = "Возраст: 30 лет"
            itemView.alarm.text = "3"
            itemView.add.setOnClickListener{
                callback.openParameter("")
            }
        }
    }
}