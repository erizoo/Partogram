package com.boiko.app.ui.main

import com.boiko.app.base.MvpView
import com.boiko.app.data.models.ResponseGoods
import com.boiko.app.data.models.ResponsePatient
import okhttp3.ResponseBody

interface MainActivityMvpView : MvpView {

    fun onError(errorBody: ResponseBody?)

    fun isSuccessfulGetedGoods(body: List<ResponseGoods>)

}