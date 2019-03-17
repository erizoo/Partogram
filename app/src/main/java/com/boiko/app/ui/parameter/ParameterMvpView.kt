package com.boiko.app.ui.parameter

import com.boiko.app.base.MvpView
import com.boiko.app.data.models.RequestFetalHeartbeat
import com.boiko.app.data.models.RequestTemp
import com.boiko.app.data.models.ResponseFetalHeartbeat
import com.boiko.app.data.models.ResponseStatus
import okhttp3.ResponseBody

interface ParameterMvpView : MvpView {

    fun onSaved(body: ResponseStatus?)

    fun onError(errorBody: ResponseBody?)

    fun onFetalHeartbeat(body: List<ResponseFetalHeartbeat>?)

    fun onPulse(body: List<ResponseFetalHeartbeat>?)

    fun onSavedTemp(body: ResponseStatus?)

    fun onTemp(body: List<RequestTemp>?)
}