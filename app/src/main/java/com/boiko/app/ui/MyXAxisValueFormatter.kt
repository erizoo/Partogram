package com.boiko.app.ui

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import java.text.SimpleDateFormat
import java.util.*

class MyXAxisValueFormatter : IAxisValueFormatter {

    override fun getFormattedValue(value: Float, axis: AxisBase?): String {
        val d = Date(java.lang.Float.valueOf(value).toLong())
        return SimpleDateFormat("dd-MM", Locale.ENGLISH).format(d)
    }
}