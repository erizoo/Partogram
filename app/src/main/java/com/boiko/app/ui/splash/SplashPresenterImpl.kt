package com.boiko.app.ui.splash

import com.boiko.app.base.BasePresenter
import com.boiko.app.data.RepositoryManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SplashPresenterImpl<V : SplashMvpView>
@Inject
constructor(repositoryManager: RepositoryManager, compositeDisposable: CompositeDisposable) :
    BasePresenter<V>(repositoryManager, compositeDisposable), SplashPresenter<V> {

    override fun checkToken() {
        compositeDisposable.add(
            repositoryManager.serviceNetwork.checkToken(repositoryManager.servicePrefs.userToken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { response ->
                    if (response.isSuccessful) {
                        mvpView.isSuccessfulToken()
                    } else {
                        mvpView.badToken(response.message(), null)
                    }
                }
        )
    }
}