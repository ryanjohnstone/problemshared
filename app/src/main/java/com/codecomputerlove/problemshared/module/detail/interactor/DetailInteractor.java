package com.codecomputerlove.problemshared.module.detail.interactor;

import com.codecomputerlove.problemshared.shared.callbacks.DistanceCallback;

public interface DetailInteractor {
    void getDistance(double longitude, double latitude, String oppName, DistanceCallback distanceCallback);
}
