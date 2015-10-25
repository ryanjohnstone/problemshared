package com.codecomputerlove.problemshared.shared;

import com.codecomputerlove.problemshared.module.detail.view.BriefActivity;
import com.codecomputerlove.problemshared.module.detail.view.DetailActivity;
import com.codecomputerlove.problemshared.module.main.view.MainActivity;
import com.codecomputerlove.problemshared.module.pager.view.PagerActivity;

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
    void inject (PagerActivity activity);
    void inject (DetailActivity activity);
    void inject(BriefActivity activity);

    public final static class Initializer {
        public static AppComponent init(boolean mockMode) {
            return DaggerAppComponent.builder()
                    .build();
        }
    }

}
