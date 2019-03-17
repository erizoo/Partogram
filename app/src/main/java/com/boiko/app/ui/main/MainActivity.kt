package com.boiko.app.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import com.boiko.app.R
import com.boiko.app.ui.adapters.LaborWomenAdapter
import com.boiko.app.base.BaseActivity
import com.boiko.app.data.models.ResponsePatient
import com.boiko.app.ui.AddActivity
import com.boiko.app.utils.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import javax.inject.Inject


class MainActivity : BaseActivity(), LaborWomenAdapter.Callback, MainActivityMvpView{

    private val laborWomenAdapter = LaborWomenAdapter(listOf())

    @Inject
    internal lateinit var presenter: MainActivityPresenter<MainActivityMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        screenComponent?.inject(this)
        presenter.onAttach(this)
        presenter.getPatient()

        Snackbar.make(recycler, resources.configuration.smallestScreenWidthDp.toString(), Snackbar.LENGTH_LONG).show()
    }

    private fun initRecyclerView(body: List<ResponsePatient>) {
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = laborWomenAdapter
        laborWomenAdapter.setCallback(this)
        laborWomenAdapter.items = body

        recycler.addItemDecoration(
            DividerItemDecoration(this, R.drawable.listing_margin_divider, true)
        )
    }

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun openParameter(type: Int) {
        val intent = Intent(this@MainActivity, AddActivity::class.java)
        intent.putExtra("ID", type)
        startActivity(intent)
    }

    override fun onError(errorBody: ResponseBody?) {

    }

    override fun onSuccessPatient(body: List<ResponsePatient>) {
        initRecyclerView(body)
    }

}
