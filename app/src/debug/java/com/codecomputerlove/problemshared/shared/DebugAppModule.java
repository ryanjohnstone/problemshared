package com.codecomputerlove.problemshared.shared;

import com.codecomputerlove.problemshared.module.main.data.MainData;
import com.codecomputerlove.problemshared.module.main.data.MainDataImpl;
import com.codecomputerlove.problemshared.module.main.interactor.MainInteractor;
import com.codecomputerlove.problemshared.module.main.interactor.MainInteractorImpl;
import com.codecomputerlove.problemshared.module.main.presenter.MainPresenter;
import com.codecomputerlove.problemshared.module.main.presenter.MainPresenterImpl;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ryanjohnstone on 18/06/15.
 */
@Module
public class DebugAppModule {

    private final boolean mockMode;

    public DebugAppModule(boolean provideMocks) {
        mockMode = provideMocks;
    }

    @Provides
    @Singleton
    MainPresenter provideMainPresenter(MainInteractor mainInteractor) {
        if (mockMode) {
            return Mockito.mock(MainPresenter.class);
        } else {
            return new MainPresenterImpl(mainInteractor);
        }
    }

    @Provides
    @Singleton
    MainInteractor provideMainInteractor() {
        if (mockMode) {
            return Mockito.mock(MainInteractor.class);
        } else {
            return new MainInteractorImpl();
        }
    }

    @Provides
    @Singleton
    MainData provideMainData() {
        if (mockMode) {
            return Mockito.mock(MainData.class);
        } else {
            return new MainDataImpl();
        }
    }


}
