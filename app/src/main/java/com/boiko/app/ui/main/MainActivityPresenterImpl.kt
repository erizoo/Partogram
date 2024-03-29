package com.boiko.app.ui.main

import com.boiko.app.base.BasePresenter
import com.boiko.app.data.RepositoryManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivityPresenterImpl<V : MainActivityMvpView>
@Inject
constructor(repositoryManager: RepositoryManager, compositeDisposable: CompositeDisposable) :
    BasePresenter<V>(repositoryManager, compositeDisposable), MainActivityPresenter<V> {


    override fun getPatient() {
        compositeDisposable.add(
            repositoryManager.serviceNetwork.getPatient(repositoryManager.servicePrefs.userToken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it.isSuccessful){
                        mvpView.onSuccessPatient(it.body()!!)
                    } else {
                        mvpView.onError(it.errorBody())
                    }
                }
        )
    }

}