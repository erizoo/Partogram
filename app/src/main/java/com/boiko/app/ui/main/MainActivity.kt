package com.boiko.app.ui.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.boiko.app.R
import com.boiko.app.base.BaseActivity
import com.boiko.app.data.models.*
import com.boiko.app.ui.adapters.GoodsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import javax.inject.Inject

class MainActivity : BaseActivity(), GoodsAdapter.Callback, MainActivityMvpView {

    private val goodsAdapter = GoodsAdapter(listOf())
    private var arrayAdapter: ArrayAdapter<String>? = null
    private var body: List<ResponseGoods> = emptyList()
    private var filterList: MutableList<ResponseGoods> = arrayListOf()

    @Inject
    internal lateinit var presenter: MainActivityPresenter<MainActivityMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        screenComponent?.inject(this)
        presenter.onAttach(this)
        initRecyclerView()

        presenter.getSuppliers()

        suppliers.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View, position: Int, id: Long) {
                val selectedItemText = parentView.getItemAtPosition(position) as String
                progress.visibility = View.VISIBLE
                recycler.visibility = View.GONE
                presenter.getGoods(selectedItemText)
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
            }
        }
        send_button.setOnClickListener {
            val list = goodsAdapter.items
            val listResult : MutableList<ResponseGoods> = arrayListOf()
            list.forEach{
                if (it.checked){
                    listResult.add(it)
                }
            }
            presenter.send(listResult)
        }

        debit_button.setOnClickListener {
            val model : MutableList<RequestModel> = arrayListOf()
            model.add(0, RequestModel(
                "", "123456", "2015-05-07", "125",
                "cash", "trade", "trade", "234"))
            val request = RequestGoods(model)
            presenter.sendDebit(request)
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
                        filterList.clear()
                        body.forEach{
                            if (it.name.contains(query, ignoreCase = true)){
                                filterList.add(it)
                            }
                        }
                        if (query.isEmpty()){
                            goodsAdapter.items = body
                        } else {
                            goodsAdapter.items = filterList.toList()
                        }
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
        this.body = body
        progress.visibility = View.GONE
        recycler.visibility = View.VISIBLE
    }

    override fun isSuccessfulGetedSuppliers(body: MutableList<ResponseSuppliers>) {
        val productNameList: List<String> = body.map { it.name }
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, productNameList)
        arrayAdapter!!.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        suppliers.adapter = arrayAdapter
    }

    override fun save(item: ResponseGoods) {

    }

    override fun isSuccessfulSendedDebit(it: ResponseDebit?) {
        print("")
    }

}
