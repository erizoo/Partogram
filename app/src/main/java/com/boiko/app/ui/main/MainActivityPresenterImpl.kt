package com.boiko.app.ui.main

import com.boiko.app.base.BasePresenter
import com.boiko.app.data.RepositoryManager
import com.boiko.app.data.models.RequestGoods
import com.boiko.app.data.models.ResponseGoods
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivityPresenterImpl<V : MainActivityMvpView>
@Inject
constructor(repositoryManager: RepositoryManager, compositeDisposable: CompositeDisposable) :
    BasePresenter<V>(repositoryManager, compositeDisposable), MainActivityPresenter<V> {

    override fun getGoods(id: String) {
        compositeDisposable.add(
            repositoryManager.serviceNetwork.goods
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { it.transit }
                .flatMapIterable { it }
                .filter { v -> v.nameSupplier == id }
                .toList()
                .toObservable()
                .subscribe { mvpView.isSuccessfulGetedGoods(it) }
        )
    }

    override fun getSuppliers() {
        compositeDisposable.add(
            repositoryManager.serviceNetwork.suppliers
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    mvpView.isSuccessfulGetedSuppliers(it.suppliers)
                }
        )
    }

    override fun send(items: List<ResponseGoods>) {
        print("")
    }

    override fun sendDebit(request: RequestGoods) {
        compositeDisposable.add(
            repositoryManager.serviceNetwork.sendDebit(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    mvpView.isSuccessfulSendedDebit(it)
                }
        )
    }
}