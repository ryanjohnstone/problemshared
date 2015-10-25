package com.codecomputerlove.problemshared.module.pager.interactor;

import com.codecomputerlove.problemshared.module.pager.data.PagerData;
import com.codecomputerlove.problemshared.shared.callbacks.OpportunityListCallback;

import javax.inject.Inject;

public class PagerInteractorImpl implements PagerInteractor {

    PagerData pagerData;

    @Inject
    public PagerInteractorImpl(PagerData pagerData) {
        this.pagerData = pagerData;
    }

    @Override
    public void getOpportunities(OpportunityListCallback callback) {
        pagerData.getOpportunities(callback);
    }

    @Override
    public void getOpportunitiesBySkillsAndCategories(String skills, String cats, OpportunityListCallback callback) {
        pagerData.getOpportunitiesBySkillsAndCategories(skills,cats,callback);
    }
}
