package com.boiko.app.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.boiko.app.di.ActivityContext;
import com.boiko.app.di.PerScreen;
import com.boiko.app.ui.login.LoginMvpView;
import com.boiko.app.ui.login.LoginPresenter;
import com.boiko.app.ui.login.LoginPresenterImpl;
import com.boiko.app.ui.main.MainActivityMvpView;
import com.boiko.app.ui.main.MainActivityPresenter;
import com.boiko.app.ui.main.MainActivityPresenterImpl;
import com.boiko.app.ui.parameter.ParameterMvpView;
import com.boiko.app.ui.parameter.ParameterPresenter;
import com.boiko.app.ui.parameter.ParameterPresenterImpl;
import com.boiko.app.ui.splash.SplashMvpView;
import com.boiko.app.ui.splash.SplashPresenter;
import com.boiko.app.ui.splash.SplashPresenterImpl;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ScreenModule {

    private final AppCompatActivity activity;

    public ScreenModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return activity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerScreen
    LoginPresenter<LoginMvpView> provideLoginPresenter(LoginPresenterImpl<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerScreen
    SplashPresenter<SplashMvpView> provideSplashPresenter(SplashPresenterImpl<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerScreen
    MainActivityPresenter<MainActivityMvpView> provideMainActivityPresenter(MainActivityPresenterImpl<MainActivityMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerScreen
    ParameterPresenter<ParameterMvpView> provideParameterPresenter(ParameterPresenterImpl<ParameterMvpView> presenter) {
        return presenter;
    }

}
