package com.codecomputerlove.problemshared.module.pager.interactor;

import com.codecomputerlove.problemshared.models.Opportunity;
import com.codecomputerlove.problemshared.shared.callbacks.OpportunityListCallback;

import java.util.List;

public interface PagerInteractor {
    void getOpportunities(OpportunityListCallback callback);
    void getOpportunitiesBySkillsAndCategories(String skills, String cats, OpportunityListCallback callback);
}
