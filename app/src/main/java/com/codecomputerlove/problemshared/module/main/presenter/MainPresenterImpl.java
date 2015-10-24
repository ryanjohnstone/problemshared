package com.codecomputerlove.problemshared.module.main.presenter;

import com.codecomputerlove.problemshared.module.main.interactor.MainInteractor;

import javax.inject.Inject;

/**
 * Created by ryanjohnstone on 19/06/15.
 */
public class MainPresenterImpl implements MainPresenter {

    MainInteractor mainInteractor;

    @Inject
    public MainPresenterImpl(MainInteractor mainInteractor) {
        this.mainInteractor = mainInteractor;
    }

}
