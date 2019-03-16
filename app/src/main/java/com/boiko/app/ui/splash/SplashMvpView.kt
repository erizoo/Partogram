package com.boiko.app.ui.splash

import com.boiko.app.base.MvpView

interface SplashMvpView : MvpView {

    fun isSuccessfulToken()

    fun badToken()
}