package com.codecomputerlove.problemshared.module.detail.presenter;

import com.codecomputerlove.problemshared.module.detail.interactor.DetailInteractor;
import com.codecomputerlove.problemshared.shared.callbacks.DistanceCallback;
import com.codecomputerlove.problemshared.shared.callbacks.OpportunityCallback;

import javax.inject.Inject;

public class DetailPresenterImpl implements DetailPresenter {

    DetailInteractor interactor;

    @Inject
    public DetailPresenterImpl(DetailInteractor detailInteractor) {
        this.interactor = detailInteractor;
    }

    @Override
    public void getDistance(double longitude, double latitude, String oppName, DistanceCallback distanceCallback) {
        interactor.getDistance(longitude,latitude, oppName, distanceCallback);
    }

    @Override
    public void getOpportunity(String oppName, OpportunityCallback opportunityCallback) {
        interactor.getOpportunity(oppName,opportunityCallback);
    }
}
