package com.codecomputerlove.problemshared.shared.callbacks;

import com.codecomputerlove.problemshared.models.Opportunity;

import java.util.List;

public interface OpportunityCallback {
    void onCompleted(Opportunity response);
    void onError(Exception error);
}
