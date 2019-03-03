package com.boiko.app;

import android.app.Application;
import android.content.ContextWrapper;
import com.boiko.app.di.component.ApplicationComponent;
import com.boiko.app.di.component.DaggerApplicationComponent;
import com.boiko.app.di.module.ApplicationModule;
import com.pixplicity.easyprefs.library.Prefs;

public class Partogram extends Application {

    private ApplicationComponent applicationComponent;

    public static Partogram instance;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
        instance = this;

        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

    }

    public static Partogram getInstance() {
        return instance;
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
