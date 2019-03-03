package com.boiko.app.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.boiko.app.R
import com.boiko.app.adapters.LaborWomenAdapter
import com.boiko.app.utils.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    private val laborWomenAdapter = LaborWomenAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()

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

}
