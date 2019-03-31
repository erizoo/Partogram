package com.boiko.app.ui.main

import com.boiko.app.base.MvpView
import com.boiko.app.data.models.ResponseDebit
import com.boiko.app.data.models.ResponseGoods
import com.boiko.app.data.models.ResponseSuppliers
import okhttp3.ResponseBody

interface MainActivityMvpView : MvpView {

    fun onError(errorBody: ResponseBody?)

    fun isSuccessfulGetedGoods(body: List<ResponseGoods>)

    fun isSuccessfulGetedSuppliers(body: MutableList<ResponseSuppliers>)

    fun isSuccessfulSendedDebit(it: ResponseDebit?)
}