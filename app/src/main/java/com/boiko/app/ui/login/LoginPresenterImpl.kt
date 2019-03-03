package com.boiko.app.ui.login

import com.boiko.app.base.BasePresenter
import com.boiko.app.data.RepositoryManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*

import javax.inject.Inject

class LoginPresenterImpl<V : LoginMvpView>
@Inject
constructor(repositoryManager: RepositoryManager, compositeDisposable: CompositeDisposable) :
    BasePresenter<V>(repositoryManager, compositeDisposable), LoginPresenter<V> {

    override fun login(login: String, password: String) {
        compositeDisposable.add(
            repositoryManager.serviceNetwork.login(login, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { response ->
                    if (response.isSuccessful) {
                        repositoryManager.setToken("Bearer " + Objects.requireNonNull(response.body()?.token))
                        mvpView.isSuccessfulLogin()
                    } else {
                        mvpView.badLogin(response.message(), null)
                    }
                }
        )
    }

}
