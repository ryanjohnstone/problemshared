package com.codecomputerlove.problemshared.shared.callbacks;

import com.codecomputerlove.problemshared.models.Opportunity;

import java.util.List;

public interface OpportunityListCallback {
    void onCompleted(List<Opportunity> response);
    void onError(Exception error);
}
