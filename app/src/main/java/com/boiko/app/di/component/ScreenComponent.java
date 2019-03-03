package com.boiko.app.di.component;

import com.boiko.app.di.PerScreen;
import com.boiko.app.di.module.ScreenModule;
import com.boiko.app.ui.login.LoginActivity;
import com.boiko.app.ui.splash.SplashActivity;
import dagger.Component;
import org.jetbrains.annotations.NotNull;

@PerScreen
@Component(modules = ScreenModule.class, dependencies = ApplicationComponent.class)
public interface ScreenComponent {

    void inject(@NotNull LoginActivity activity);

    void inject(@NotNull SplashActivity activity);
}
