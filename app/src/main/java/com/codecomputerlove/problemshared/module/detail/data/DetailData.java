package com.codecomputerlove.problemshared.module.detail.data;

import com.codecomputerlove.problemshared.shared.callbacks.DistanceCallback;
import com.codecomputerlove.problemshared.shared.callbacks.OpportunityCallback;

public interface DetailData {
    void getDistance(double longitude, double latitude, String oppName, DistanceCallback distanceCallback);

    void getOpportunity(String oppName, OpportunityCallback opportunityCallback);
}
