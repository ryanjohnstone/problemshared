package com.codecomputerlove.problemshared.shared;

import com.codecomputerlove.problemshared.shared.callbacks.OpportunityListCallback;

public interface Api {

    void getAllOpportunities(OpportunityListCallback callback);
}
