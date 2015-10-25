package com.codecomputerlove.problemshared.module.detail.data;

import com.codecomputerlove.problemshared.shared.Api;
import com.codecomputerlove.problemshared.shared.callbacks.DistanceCallback;

import javax.inject.Inject;

public class DetailDataImpl implements DetailData {

    Api api;

    @Inject
    public DetailDataImpl(Api api) {
        this.api = api;
    }

    @Override
    public void getDistance(double longitude, double latitude, String oppName, DistanceCallback distanceCallback) {
        api.getDistance(longitude,latitude,oppName,distanceCallback);
    }
}
