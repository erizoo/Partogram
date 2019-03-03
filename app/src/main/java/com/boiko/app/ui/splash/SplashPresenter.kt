package com.boiko.app.ui.splash

import com.boiko.app.base.MvpPresenter
import com.boiko.app.ui.login.LoginMvpView

interface SplashPresenter <V : SplashMvpView> : MvpPresenter<V> {

    fun checkToken()

}
