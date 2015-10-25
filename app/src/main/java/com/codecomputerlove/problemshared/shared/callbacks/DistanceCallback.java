package com.codecomputerlove.problemshared.shared.callbacks;

import com.codecomputerlove.problemshared.models.Opportunity;

import java.util.List;

public interface DistanceCallback {
    void onCompleted(String response);
    void onError(Exception error);
}
