package com.boiko.app.ui.login

import com.boiko.app.base.MvpView

interface LoginMvpView : MvpView {

    abstract fun isSuccessfulLogin()

    abstract fun badLogin(message: String, nothing: Nothing?)

}
