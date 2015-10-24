package com.codecomputerlove.problemshared.module.pager.data;

import com.codecomputerlove.problemshared.shared.Api;
import com.codecomputerlove.problemshared.shared.callbacks.OpportunityListCallback;

import javax.inject.Inject;

public class PagerDataImpl implements PagerData {

    Api api;

    @Inject
    public PagerDataImpl(Api api) {
        this.api = api;
    }

    @Override
    public void getOpportunities(OpportunityListCallback callback) {
        api.getAllOpportunities(callback);
    }
}
