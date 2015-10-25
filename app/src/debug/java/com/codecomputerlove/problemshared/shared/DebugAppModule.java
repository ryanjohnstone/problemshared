package com.codecomputerlove.problemshared.shared;

import com.codecomputerlove.problemshared.module.detail.data.DetailData;
import com.codecomputerlove.problemshared.module.detail.data.DetailDataImpl;
import com.codecomputerlove.problemshared.module.detail.interactor.DetailInteractor;
import com.codecomputerlove.problemshared.module.detail.interactor.DetailInteractorImpl;
import com.codecomputerlove.problemshared.module.detail.presenter.DetailPresenter;
import com.codecomputerlove.problemshared.module.detail.presenter.DetailPresenterImpl;
import com.codecomputerlove.problemshared.module.main.data.MainData;
import com.codecomputerlove.problemshared.module.main.data.MainDataImpl;
import com.codecomputerlove.problemshared.module.main.interactor.MainInteractor;
import com.codecomputerlove.problemshared.module.main.interactor.MainInteractorImpl;
import com.codecomputerlove.problemshared.module.main.presenter.MainPresenter;
import com.codecomputerlove.problemshared.module.main.presenter.MainPresenterImpl;
import com.codecomputerlove.problemshared.module.pager.data.PagerData;
import com.codecomputerlove.problemshared.module.pager.data.PagerDataImpl;
import com.codecomputerlove.problemshared.module.pager.interactor.PagerInteractor;
import com.codecomputerlove.problemshared.module.pager.interactor.PagerInteractorImpl;
import com.codecomputerlove.problemshared.module.pager.presenter.PagerPresenter;
import com.codecomputerlove.problemshared.module.pager.presenter.PagerPresenterImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

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
    OkHttpClient provideClient() {
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        return gson;
    }

    @Provides
    @Singleton
    RestApi provideRestApi(OkHttpClient client) {
        return new RestApiImpl(client);
    }


    @Provides
    @Singleton
    Api provideApi(RestApi restApi, Gson gson) {
        //return new MockApiImpl(gson);

        return new ApiImpl(restApi, gson);
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

    @Provides
    @Singleton
    PagerPresenter providePagerPresenter(PagerInteractor pagerInteractor) {
        if (mockMode) {
            return Mockito.mock(PagerPresenter.class);
        }
        return new PagerPresenterImpl(pagerInteractor);
    }

    @Provides
    @Singleton
    PagerInteractor providePagerInteractor(PagerData pagerData)
    {
        if (mockMode) {
            return Mockito.mock(PagerInteractor.class);
        }
        return new PagerInteractorImpl(pagerData);
    }

    @Provides
    @Singleton
    PagerData providePagerData(Api api)
    {
        if (mockMode) {
            return Mockito.mock(PagerData.class);
        }
        return new PagerDataImpl(api);
    }

    @Provides
    @Singleton
    DetailPresenter provideDetailPresenter(DetailInteractor detailInteractor) {
        if (mockMode) {
            return Mockito.mock(DetailPresenter.class);
        }
        return new DetailPresenterImpl(detailInteractor);
    }

    @Provides
    @Singleton
    DetailInteractor provideDetailInteractor(DetailData detailData)
    {
        if (mockMode) {
            return Mockito.mock(DetailInteractor.class);
        }
        return new DetailInteractorImpl(detailData);
    }

    @Provides
    @Singleton
    DetailData provideDetailData(Api api)
    {
        if (mockMode) {
            return Mockito.mock(DetailData.class);
        }
        return new DetailDataImpl(api);
    }

}
