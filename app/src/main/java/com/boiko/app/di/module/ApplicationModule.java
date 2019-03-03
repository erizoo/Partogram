package com.boiko.app.di.module;

import android.content.Context;
import com.boiko.app.Partogram;
import com.boiko.app.data.RepositoryManager;
import com.boiko.app.data.RepositoryManagerImpl;
import com.boiko.app.data.ServicePrefs;
import com.boiko.app.data.ServicePrefsImpl;
import com.boiko.app.di.ApplicationContext;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class ApplicationModule {

    private final Partogram application;

    public ApplicationModule(Partogram application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    Partogram provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    RepositoryManager provideRepositoryManager(RepositoryManagerImpl repositoryManager) {
        return repositoryManager;
    }

    @Provides
    @Singleton
    ServicePrefs provideServicePrefs(ServicePrefsImpl servicePrefs) {
        return servicePrefs;
    }

}

