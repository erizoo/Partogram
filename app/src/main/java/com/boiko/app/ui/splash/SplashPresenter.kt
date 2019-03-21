package com.boiko.app.ui.splash

import com.boiko.app.base.MvpPresenter

interface SplashPresenter <V : SplashMvpView> : MvpPresenter<V> {

    fun checkToken()

}
