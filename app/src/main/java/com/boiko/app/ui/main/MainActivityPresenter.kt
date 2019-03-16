package com.boiko.app.ui.main

import com.boiko.app.base.MvpPresenter
import com.boiko.app.ui.login.LoginMvpView

interface MainActivityPresenter <V : MainActivityMvpView> : MvpPresenter<V> {

    fun getPatient()

}