package com.boiko.app.ui.main

import com.boiko.app.base.BasePresenter
import com.boiko.app.data.RepositoryManager
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivityPresenterImpl<V : MainActivityMvpView>
@Inject
constructor(repositoryManager: RepositoryManager, compositeDisposable: CompositeDisposable) :
    BasePresenter<V>(repositoryManager, compositeDisposable), MainActivityPresenter<V> {

}