package com.boiko.app.di.component;

import com.boiko.app.di.PerScreen;
import com.boiko.app.di.module.ScreenModule;
import com.boiko.app.ui.main.MainActivity;
import com.boiko.app.ui.splash.SplashActivity;
import dagger.Component;
import org.jetbrains.annotations.NotNull;

@PerScreen
@Component(modules = ScreenModule.class, dependencies = ApplicationComponent.class)
public interface ScreenComponent {

    void inject(@NotNull SplashActivity activity);

    void inject(@NotNull MainActivity activity);
}
