package com.boiko.app.ui

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.boiko.app.R
import com.boiko.app.adapters.LaborWomenAdapter
import com.boiko.app.utils.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_labor_women.*


class MainActivity : AppCompatActivity(), LaborWomenAdapter.Callback{

    private val laborWomenAdapter = LaborWomenAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()

        Snackbar.make(recycler, resources.configuration.smallestScreenWidthDp.toString(), Snackbar.LENGTH_LONG).show()
    }

    private fun initRecyclerView() {
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = laborWomenAdapter

        val offers = ArrayList<String>()
        offers.add("Spraklin cair repair")
        offers.add("Spraklin cair repair")
        offers.add("Spraklin cair repair")
        offers.add("Spraklin cair repair")
        offers.add("Spraklin cair repair")
        offers.add("Spraklin cair repair")
        laborWomenAdapter.items = offers

        recycler.addItemDecoration(
            DividerItemDecoration(this, R.drawable.listing_margin_divider, true)
        )
    }

    override fun openParameter(type: String) {
        startActivity(Intent(this@MainActivity, AddActivity::class.java))
    }

}
