package com.boiko.app.ui.splash

import com.boiko.app.base.MvpView

interface SplashMvpView : MvpView {

    abstract fun isSuccessfulToken()

    abstract fun badToken(message: String, nothing: Nothing?)
}