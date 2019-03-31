package com.boiko.app.ui.main

import com.boiko.app.base.MvpPresenter
import com.boiko.app.data.models.ResponseGoods

interface MainActivityPresenter <V : MainActivityMvpView> : MvpPresenter<V> {

    fun getGoods(id: String)

    fun getSuppliers()

    fun send(items: List<ResponseGoods>)

}