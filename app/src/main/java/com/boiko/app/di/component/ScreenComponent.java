package com.boiko.app.di.component;

import com.boiko.app.di.PerScreen;
import com.boiko.app.di.module.ScreenModule;
import dagger.Component;

@PerScreen
@Component(modules = ScreenModule.class, dependencies = ApplicationComponent.class)
public interface ScreenComponent {

}
