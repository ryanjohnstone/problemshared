package com.codecomputerlove.problemshared.shared;

import com.codecomputerlove.problemshared.models.Opportunity;
import com.codecomputerlove.problemshared.shared.callbacks.OpportunityListCallback;
import com.codecomputerlove.problemshared.shared.callbacks.StringCallback;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

public class ApiImpl implements Api {

    RestApi restApi;
    final Gson gson;

    static final String ALL_OPPORTUNITIES_URL = "http://aproblemsharedapi.apphb.com/opportunities/skills/all/categories/all";

    @Inject
    public ApiImpl(RestApi restApi, Gson gson) {
        this.restApi = restApi;
        this.gson = gson;
    }

    @Override
    public void getAllOpportunities(final OpportunityListCallback callback) {

        restApi.get(ALL_OPPORTUNITIES_URL, new StringCallback() {
            @Override
            public void onCompleted(String response) {
                Type listOfRoomEntityType = new TypeToken<List<Opportunity>>() {
                }.getType();

                List<Opportunity> opportunities;
                try {
                    opportunities = gson.fromJson(response, listOfRoomEntityType);
                } catch (JsonSyntaxException e) {
                    callback.onError(e);
                    return;
                }

                callback.onCompleted(opportunities);
            }

            @Override
            public void onError(Exception error) {
                callback.onError(error);
            }
        });


    }
}
