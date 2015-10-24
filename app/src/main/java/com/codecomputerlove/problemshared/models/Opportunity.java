package com.codecomputerlove.problemshared.models;

import com.google.gson.annotations.SerializedName;

public class Opportunity {

    @SerializedName("opportunity_name")
    private String opportunityName;
    @SerializedName("description")
    private String description;
    @SerializedName("charity_name")
    private String charity;

    public String getOpportunityName() {
        return opportunityName;
    }

    public void setOpportunityName(String opportunityName) {
        this.opportunityName = opportunityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCharity() {
        return charity;
    }

    public void setCharity(String charity) {
        this.charity = charity;
    }
}
