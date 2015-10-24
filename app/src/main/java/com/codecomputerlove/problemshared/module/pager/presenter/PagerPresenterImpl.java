package com.codecomputerlove.problemshared.module.pager.presenter;

import com.codecomputerlove.problemshared.module.pager.interactor.PagerInteractor;
import com.codecomputerlove.problemshared.shared.callbacks.OpportunityListCallback;

import javax.inject.Inject;

public class PagerPresenterImpl implements PagerPresenter{

    PagerInteractor interactor;

    @Inject
    public PagerPresenterImpl(PagerInteractor pagerInteractor) {
        this.interactor = pagerInteractor;
    }

    @Override
    public void getOpportunities(OpportunityListCallback callback) {
        interactor.getOpportunities(callback);
    }
}
