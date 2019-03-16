package com.boiko.app.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputFilter
import android.view.View
import com.jjoe64.graphview.DefaultLabelFormatter
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlinx.android.synthetic.main.activity_parameter.*
import java.text.SimpleDateFormat
import java.util.*


class ParameterActivity : AppCompatActivity() {

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.boiko.app.R.layout.activity_parameter)

        val type = intent.getStringExtra("TYPE")
        val id = intent.getStringExtra("ID")

        initView(type)

        // generate Dates
        val calendar = Calendar.getInstance()
        val d1 = calendar.time
        calendar.add(Calendar.DATE, 1)
        val d2 = calendar.time
        calendar.add(Calendar.DATE, 1)
        val d3 = calendar.time

        val simpleDateFormat = SimpleDateFormat("HH:mm")
        val series = LineGraphSeries<DataPoint>(
            arrayOf(DataPoint(d1, 1.0), DataPoint(d2, 2.5))
        )
        graph.addSeries(series)
        graph.gridLabelRenderer.labelFormatter = object : DefaultLabelFormatter() {
            override fun formatLabel(value: Double, isValueX: Boolean): String {
                return if (isValueX) {
                    simpleDateFormat.format(value)
                } else {
                    super.formatLabel(value, isValueX)
                }
            }
        }
        graph.gridLabelRenderer.numHorizontalLabels = 3
        graph.viewport.setMinX(d1.time.toDouble())
        graph.viewport.setMaxX(d3.time.toDouble())
        graph.viewport.isXAxisBoundsManual = true

        abort.setOnClickListener {
            onBackPressed()
        }
        save.setOnClickListener {
            if (type == "Сердцебиение плода") {
                edit_text.hint = "Введите количество ударов"
            }
        }

//        val adapterAmnioticFluid =
//            ArrayAdapter.createFromResource(this, R.array.amniotic_fluid, android.R.layout.simple_spinner_item)
//        adapterAmnioticFluid.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//
//        amniotic_fluid.adapter = adapterAmnioticFluid
//
//        val adapterAmnioticFluidConfig =
//            ArrayAdapter.createFromResource(this, R.array.amniotic_fluid_config, android.R.layout.simple_spinner_item)
//        adapterAmnioticFluidConfig.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//
//        amniotic_fluid_config.adapter = adapterAmnioticFluidConfig
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