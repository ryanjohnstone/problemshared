package com.codecomputerlove.problemshared.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Opportunity implements Serializable{

    @SerializedName("opportunity_name")
    private String opportunityName;
    @SerializedName("description")
    private String description;
    @SerializedName("charity_name")
    private String charity;
    @SerializedName("activities")
    private String activities;
    @SerializedName("contact_name")
    private String contactName;
    @SerializedName("telephone")
    private String telephone;
    @SerializedName("address")
    private String address;
    @SerializedName("website")
    private String website;
    @SerializedName("facebook_account_name")
    private String facebookAccountName;
    @SerializedName("twitter_account_name")
    private String twitterAccountName;
    @SerializedName("youtube_account_name")
    private String youtubeAccountName;
    @SerializedName("time_of_Activity")
    private String mTimeOfActivity;

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

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFacebookAccountName() {
        return facebookAccountName;
    }

    public void setFacebookAccountName(String facebookAccountName) {
        this.facebookAccountName = facebookAccountName;
    }

    public String getTwitterAccountName() {
        return twitterAccountName;
    }

    public void setTwitterAccountName(String twitterAccountName) {
        this.twitterAccountName = twitterAccountName;
    }

    public String getYoutubeAccountName() {
        return youtubeAccountName;
    }

    public void setYoutubeAccountName(String youtubeAccountName) {
        this.youtubeAccountName = youtubeAccountName;
    }

    public String getmTimeOfActivity() {
        return mTimeOfActivity;
    }

    public void setmTimeOfActivity(String mTimeOfActivity) {
        this.mTimeOfActivity = mTimeOfActivity;
    }
}
