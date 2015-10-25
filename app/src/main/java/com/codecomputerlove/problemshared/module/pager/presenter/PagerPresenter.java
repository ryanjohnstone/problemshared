package com.codecomputerlove.problemshared.module.pager.presenter;

import com.codecomputerlove.problemshared.models.Opportunity;
import com.codecomputerlove.problemshared.shared.callbacks.OpportunityListCallback;

import java.util.List;

public interface PagerPresenter {
    void getOpportunities(OpportunityListCallback callback);
    void getOpportunitiesBySkillsAndCategories(String skills, String cats, OpportunityListCallback callback);
}
