package com.boiko.app.ui.parameter

import com.boiko.app.base.MvpPresenter

interface ParameterPresenter <V : ParameterMvpView> : MvpPresenter<V> {

    fun fetalHeartbeat(id: Int, edit_text: String, format: String?)

    fun getFetalHeartbeat(idLabor: Int)

    fun getPulse(idLabor: Int)

    fun savePulse(id: Int, edit_text: String, format: String?)

    fun saveTemp(id: Int, toString: String, format: String?)

    fun getTemp(idLabor: Int)

}