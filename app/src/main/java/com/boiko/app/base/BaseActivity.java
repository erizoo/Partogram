package com.boiko.app.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.boiko.app.Partogram;
import com.boiko.app.di.component.DaggerScreenComponent;
import com.boiko.app.di.component.ScreenComponent;
import com.boiko.app.di.module.ScreenModule;
import io.reactivex.disposables.CompositeDisposable;

import javax.inject.Inject;

public abstract class BaseActivity extends AppCompatActivity implements MvpView {

    @Inject
    CompositeDisposable compositeDisposable;

    private ScreenComponent screenComponent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());

        screenComponent = DaggerScreenComponent.builder()
                .screenModule(new ScreenModule(this))
                .applicationComponent(((Partogram) getApplication()).getApplicationComponent())
                .build();
    }

    protected abstract int getContentView();

    public ScreenComponent getScreenComponent() {
        return screenComponent;
    }

    @Override
    protected void onDestroy() {
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
        super.onDestroy();
    }

}
