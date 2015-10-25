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
    OkHttpClient provideClient() {
        return new OkHttpClient();
    }

    @Singleton
    @Provides
    Gson provideGson() {

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        return gson;
    }

    @Provides
    @Singleton RestApi provideRestApi(OkHttpClient client) {
        return new RestApiImpl(client);
    }

    @Provides
    @Singleton Api provideApi(RestApi restApi, Gson gson) {
        return new ApiImpl(restApi, gson);
    }

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

    @Provides
    @Singleton
    PagerPresenter providePagerPresenter(PagerInteractor pagerInteractor) {
        return new PagerPresenterImpl(pagerInteractor);
    }

    @Provides
    @Singleton
    PagerInteractor providePagerInteractor(PagerData pagerData)
    {
        return new PagerInteractorImpl(pagerData);
    }

    @Provides
    @Singleton
    PagerData providePagerData(Api api)
    {
        return new PagerDataImpl(api);
    }

    @Provides
    @Singleton
    DetailPresenter provideDetailPresenter(DetailInteractor detailInteractor) {
        return new DetailPresenterImpl(detailInteractor);
    }

    @Provides
    @Singleton
    DetailInteractor provideDetailInteractor(DetailData detailData)
    {
        return new DetailInteractorImpl(detailData);
    }

    @Provides
    @Singleton
    DetailData provideDetailData(Api api)
    {
        return new DetailDataImpl(api);
    }
}
