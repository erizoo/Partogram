package com.boiko.app.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.boiko.app.R
import com.boiko.app.ui.adapters.ParametersAdapter
import com.boiko.app.ui.parameter.ParameterActivity
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity(), ParametersAdapter.Callback {

    private val parametersAdapter = ParametersAdapter(listOf())
    private var idLabor: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        initRecyclerView()
        val id = intent.getIntExtra("ID", 1)
        idLabor = id
    }

    private fun initRecyclerView() {
        add_recycler_view.layoutManager = LinearLayoutManager(this)
        add_recycler_view.adapter = parametersAdapter
        parametersAdapter.setCallback(this)

        val offers = ArrayList<String>()
        offers.add("Сердцебиение плода")
//        offers.add("Околоплодные воды и конфигурация")
//        offers.add("Раскрытие шейки матки")
//        offers.add("Прохождение головки плода")
//        offers.add("Маточные сокращения каждые 10 минут")
//        offers.add("Окситоцин")
//        offers.add("Полученные лекарства и растворы")
//        offers.add("Пульс")
//        offers.add("Давление")
        offers.add("Температура тела")
//        offers.add("Моча")
        parametersAdapter.items = offers
    }

    override fun openParameter(type: String) {
        val intent = Intent(this@AddActivity, ParameterActivity::class.java)
        intent.putExtra("TYPE", type)
        intent.putExtra("ID", idLabor)
        startActivity(intent)
    }

}