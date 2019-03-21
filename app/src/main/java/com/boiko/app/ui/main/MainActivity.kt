package com.boiko.app.ui.main

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.boiko.app.R
import com.boiko.app.base.BaseActivity
import com.boiko.app.data.models.ResponseGoods
import com.boiko.app.data.models.ResponsePatient
import com.boiko.app.ui.adapters.GoodsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import javax.inject.Inject


class MainActivity : BaseActivity(), GoodsAdapter.Callback, MainActivityMvpView {

    private val goodsAdapter = GoodsAdapter(listOf())

    @Inject
    internal lateinit var presenter: MainActivityPresenter<MainActivityMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        screenComponent?.inject(this)
        presenter.onAttach(this)
        initRecyclerView()

        val adapter = ArrayAdapter.createFromResource(this, R.array.suppliers, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        suppliers.adapter = adapter

        suppliers.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View, position: Int, id: Long) {
                if (position == 0){
                    presenter.getGoods(0)
                } else if (position == 1){
                    presenter.getGoods(1)
                }
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {

            }

        }
    }

    private fun initRecyclerView() {

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = goodsAdapter
        goodsAdapter.setCallback(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_search -> {
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String): Boolean {
                        item.collapseActionView()
                        return false
                    }

                    override fun onQueryTextChange(query: String): Boolean {
                        return false
                    }
                })
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun onError(errorBody: ResponseBody?) {

    }

    override fun openParameter(type: Int) {

    }

    override fun isSuccessfulGetedGoods(body: List<ResponseGoods>) {
        goodsAdapter.items = body

    }


}
