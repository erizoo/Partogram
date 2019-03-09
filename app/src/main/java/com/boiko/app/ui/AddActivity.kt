package com.boiko.app.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.boiko.app.R
import com.boiko.app.adapters.ParametersAdapter
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity(), ParametersAdapter.Callback {

    private val parametersAdapter = ParametersAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        add_recycler_view.layoutManager = LinearLayoutManager(this)
        add_recycler_view.adapter = parametersAdapter
        parametersAdapter.setCallback(this)

        val offers = ArrayList<String>()
        offers.add("Сердцебиение плода")
        offers.add("Околоплодные воды и конфигурация")
        offers.add("Раскрытие шейки матки")
        offers.add("Прохождение головки плода")
        offers.add("Маточные сокращения каждые 10 минут")
        offers.add("Окситоцин")
        offers.add("Полученные лекарства и растворы")
        offers.add("Пульс")
        offers.add("Давление")
        offers.add("Температура тела")
        offers.add("Моча")
        parametersAdapter.items = offers
    }

    override fun openParameter(type: String) {
        startActivity(Intent(this@AddActivity, ParameterActivity::class.java))
    }

}