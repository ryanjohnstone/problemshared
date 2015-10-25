package com.codecomputerlove.problemshared.module.detail.data;

import com.codecomputerlove.problemshared.shared.callbacks.DistanceCallback;

public interface DetailData {
    void getDistance(double longitude, double latitude, String oppName, DistanceCallback distanceCallback);
}
