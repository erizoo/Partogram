package com.boiko.app.ui.adapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.boiko.app.R
import com.boiko.app.base.BaseRecyclerViewAdapter
import com.boiko.app.data.models.ResponsePatient
import kotlinx.android.synthetic.main.list_item_labor_women.view.*

class LaborWomenAdapter(items: List<ResponsePatient>) : BaseRecyclerViewAdapter<LaborWomenAdapter.ViewHolder>() {

    private lateinit var callback: Callback

    override var items: List<ResponsePatient> = items
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

    fun setCallback(callback: Callback){
        this.callback = callback
    }

    interface Callback{

        fun openParameter(type: Int)

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(item: ResponsePatient) {
            itemView.name.text = item.fullName + System.getProperty("line.separator") + item.bloodGroup
            itemView.time_return.text = "Последнее изменение: 36 минут назад"
            itemView.time_begin.text = "Время начала:  " + item.timeOfHospitalization
            itemView.head.text = "Положение шейки матки и головки: 5/3 см"
            itemView.age.text = "Возраст: " + item.age
            itemView.alarm.text = "3"
            itemView.add.setOnClickListener{
                callback.openParameter(item.id)
            }
        }
    }
}