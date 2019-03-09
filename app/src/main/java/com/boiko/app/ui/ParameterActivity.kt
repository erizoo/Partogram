package com.boiko.app.ui

import android.R.attr.x
import android.R.attr.y
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.boiko.app.R
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.activity_parameter.*
import java.util.*


class ParameterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parameter)

        val i = (Date().time / 1000).toInt()
        val i = (Date().time  / 1000).toInt()
        val f = i.toFloat()

        val entries = ArrayList<Entry>()
        entries.add(Entry(f, 15F))
        entries.add(Entry(f, 25F))
        entries.add(Entry(f, 35F))
        entries.add(Entry(f, 45F))

        val dataSet = LineDataSet(entries, "Label")
        dataSet.color = Color.BLUE;
        dataSet.valueTextColor = Color.BLACK


        val lineData = LineData(dataSet)
        chart.data = lineData
        chart.invalidate()

        val xAxis = chart.xAxis
        xAxis.valueFormatter = MyXAxisValueFormatter()
    }

}