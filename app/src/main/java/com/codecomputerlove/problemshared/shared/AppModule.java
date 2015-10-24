package com.codecomputerlove.problemshared.shared;

import com.codecomputerlove.problemshared.module.main.data.MainData;
import com.codecomputerlove.problemshared.module.main.data.MainDataImpl;
import com.codecomputerlove.problemshared.module.main.interactor.MainInteractor;
import com.codecomputerlove.problemshared.module.main.interactor.MainInteractorImpl;
import com.codecomputerlove.problemshared.module.main.presenter.MainPresenter;
import com.codecomputerlove.problemshared.module.main.presenter.MainPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ryanjohnstone on 18/06/15.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    MainPresenter provideMainPresenter(MainInteractor mainInteractor) {
        return new MainPresenterImpl(mainInteractor);
    }

    @Provides
    @Singleton
    MainInteractor provideMainInteractor() {
        return new MainInteractorImpl();
    }

    @Provides
    @Singleton
    MainData provideMainData() {
        return new MainDataImpl();
    }

}
