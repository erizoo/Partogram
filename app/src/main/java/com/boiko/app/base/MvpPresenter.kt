package com.boiko.app.base

import com.boiko.app.data.RepositoryManager
import io.reactivex.disposables.CompositeDisposable

interface MvpPresenter<V> {

    val compositeDisposable: CompositeDisposable

    val mvpView: V

    val repositoryManager: RepositoryManager

    fun onAttach(mvpView: V)

    fun onDetach()

    fun onDestroy()

}
