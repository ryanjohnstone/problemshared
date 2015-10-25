package com.codecomputerlove.problemshared.shared;

import com.codecomputerlove.problemshared.shared.callbacks.DistanceCallback;
import com.codecomputerlove.problemshared.shared.callbacks.OpportunityListCallback;

public interface Api {

    void getAllOpportunities(OpportunityListCallback callback);

    void getDistance(double longitude, double latitude, String oppName, DistanceCallback distanceCallback);
}
