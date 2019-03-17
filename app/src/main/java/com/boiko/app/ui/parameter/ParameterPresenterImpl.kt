package com.boiko.app.ui.parameter

import com.boiko.app.base.BasePresenter
import com.boiko.app.data.RepositoryManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ParameterPresenterImpl<V : ParameterMvpView>
@Inject
constructor(repositoryManager: RepositoryManager, compositeDisposable: CompositeDisposable) :
    BasePresenter<V>(repositoryManager, compositeDisposable), ParameterPresenter<V> {

    override fun getTemp(idLabor: Int) {
        compositeDisposable.add(
            repositoryManager.serviceNetwork.getTemp(
                repositoryManager.servicePrefs.userToken,
                idLabor
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it.isSuccessful) {
                        mvpView.onTemp(it.body())
                    } else {
                        mvpView.onError(it.errorBody())
                    }
                }
        )
    }

    override fun saveTemp(id: Int, data: String, format: String?) {
        compositeDisposable.add(
            repositoryManager.serviceNetwork.saveTemp(
                repositoryManager.servicePrefs.userToken,
                id,
                data,
                format
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it.isSuccessful) {
                        mvpView.onSavedTemp(it.body())
                    } else {
                        mvpView.onError(it.errorBody())
                    }
                }
        )
    }

    override fun savePulse(id: Int, edit_text: String, format: String?) {
        compositeDisposable.add(
            repositoryManager.serviceNetwork.savePulse(
                repositoryManager.servicePrefs.userToken,
                id,
                edit_text,
                format
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it.isSuccessful) {
                        mvpView.onSaved(it.body())
                    } else {
                        mvpView.onError(it.errorBody())
                    }
                }
        )
    }

    override fun getPulse(idLabor: Int) {
        compositeDisposable.add(
            repositoryManager.serviceNetwork.getPulse(
                repositoryManager.servicePrefs.userToken,
                idLabor
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it.isSuccessful) {
                        mvpView.onPulse(it.body())
                    } else {
                        mvpView.onError(it.errorBody())
                    }
                }
        )
    }

    override fun fetalHeartbeat(id: Int, edit_text: String, format: String?) {
        compositeDisposable.add(
            repositoryManager.serviceNetwork.fetalHeartbeat(
                repositoryManager.servicePrefs.userToken,
                id,
                edit_text,
                format
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it.isSuccessful) {
                        mvpView.onSaved(it.body())
                    } else {
                        mvpView.onError(it.errorBody())
                    }
                }
        )
    }

    override fun getFetalHeartbeat(idLabor: Int) {
        compositeDisposable.add(
            repositoryManager.serviceNetwork.getFetalHeartbeat(
                repositoryManager.servicePrefs.userToken,
                idLabor
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it.isSuccessful) {
                        mvpView.onFetalHeartbeat(it.body())
                    } else {
                        mvpView.onError(it.errorBody())
                    }
                }
        )
    }
}