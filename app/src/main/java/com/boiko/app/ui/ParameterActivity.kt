package com.boiko.app.ui

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputFilter
import android.view.View
import android.widget.ArrayAdapter
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

        val type = intent.getStringExtra("TYPE")

        initView(type)

        val i = (Date().time / 1000).toInt()
        val f = i.toFloat()

        val entries = ArrayList<Entry>()
        entries.add(Entry(f, 15F))
        entries.add(Entry(f, 25F))
        entries.add(Entry(f, 35F))
        entries.add(Entry(f, 45F))

        val dataSet = LineDataSet(entries, "Label")
        dataSet.color = Color.BLUE
        dataSet.valueTextColor = Color.BLACK


        val lineData = LineData(dataSet)
        chart.data = lineData
        chart.invalidate()

        val xAxis = chart.xAxis
        xAxis.valueFormatter = MyXAxisValueFormatter()

        abort.setOnClickListener {
            onBackPressed()
        }

        val adapterAmnioticFluid =
            ArrayAdapter.createFromResource(this, R.array.amniotic_fluid, android.R.layout.simple_spinner_item)
        adapterAmnioticFluid.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        amniotic_fluid.adapter = adapterAmnioticFluid

        val adapterAmnioticFluidConfig =
            ArrayAdapter.createFromResource(this, R.array.amniotic_fluid_config, android.R.layout.simple_spinner_item)
        adapterAmnioticFluidConfig.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        amniotic_fluid_config.adapter = adapterAmnioticFluidConfig
    }

    private fun initView(type: String?) {
        if (type.equals("Сердцебиение плода")) {
            edit_text2.visibility = View.GONE
            edit_text.hint = "Введите количество ударов"
            title_page.text = "Сердцебиение плода"
            edit_text.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(3))
        } else if(type.equals("Околоплодные воды и конфигурация")) {

        }
    }

}