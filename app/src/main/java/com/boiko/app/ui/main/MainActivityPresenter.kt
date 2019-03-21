package com.boiko.app.ui.main

import com.boiko.app.base.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface MainActivityPresenter <V : MainActivityMvpView> : MvpPresenter<V> {

    fun getGoods(id: Int) {
        compositeDisposable.add(
            repositoryManager.serviceNetwork.getGoods(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {response ->
                    if (response.isSuccessful){
                        mvpView.isSuccessfulGetedGoods(response.body()!!)
                    } else {
                        mvpView.onError(response.errorBody())
                    }
                }
        )
    }


}