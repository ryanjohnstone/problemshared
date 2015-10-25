package com.codecomputerlove.problemshared.module.detail.interactor;

import com.codecomputerlove.problemshared.module.detail.data.DetailData;
import com.codecomputerlove.problemshared.shared.callbacks.DistanceCallback;

import javax.inject.Inject;

public class DetailInteractorImpl implements DetailInteractor {

    DetailData data;

    @Inject
    public DetailInteractorImpl(DetailData data) {
        this.data = data;
    }

    @Override
    public void getDistance(double longitude, double latitude, String oppName, DistanceCallback distanceCallback) {
        data.getDistance(longitude,latitude,oppName,distanceCallback);
    }
}
