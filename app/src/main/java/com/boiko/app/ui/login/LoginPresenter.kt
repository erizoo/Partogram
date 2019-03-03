package com.boiko.app.ui.login

import com.boiko.app.base.MvpPresenter

interface LoginPresenter<V : LoginMvpView> : MvpPresenter<V> {

    fun login(login: String, password: String)

}
