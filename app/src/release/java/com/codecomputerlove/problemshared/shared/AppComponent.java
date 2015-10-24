package com.codecomputerlove.problemshared.shared;

import com.codecomputerlove.problemshared.module.main.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ryanjohnstone on 18/06/15.
 */
@Singleton
@Component(modules = {AppModule.class} )
public interface AppComponent {

    void inject(BaseActivity activity);
    void inject(MainActivity activity);

    public final static class Initializer {
        public static AppComponent init(boolean mockMode) {
            return DaggerAppComponent.builder()
                    .build();
        }
    }

}
