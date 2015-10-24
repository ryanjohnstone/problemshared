package com.codecomputerlove.problemshared.models;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.List;

public class Charity {

    @SerializedName("title")
    private String title;
    @SerializedName("charity_number")
    private String charityNumber;
    @SerializedName("activities")
    private List<Activity> activities;
}
