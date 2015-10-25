package com.codecomputerlove.problemshared.module.detail.presenter;

import com.codecomputerlove.problemshared.shared.callbacks.DistanceCallback;

public interface DetailPresenter {
    void getDistance(double longitude, double latitude, String oppName, DistanceCallback distanceCallback);

}
