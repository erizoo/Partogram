package com.boiko.app.di.component;

import android.content.Context;
import com.boiko.app.Partogram;
import com.boiko.app.data.RepositoryManager;
import com.boiko.app.di.ApplicationContext;
import com.boiko.app.di.module.ApiModule;
import com.boiko.app.di.module.ApplicationModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

    void inject(Partogram application);

    @ApplicationContext
    Context context();

    RepositoryManager getRepositoryManager();

}

