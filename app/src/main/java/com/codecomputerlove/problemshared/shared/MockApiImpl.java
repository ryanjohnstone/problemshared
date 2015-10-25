package com.codecomputerlove.problemshared.shared;

import com.codecomputerlove.problemshared.models.Opportunity;
import com.codecomputerlove.problemshared.shared.callbacks.DistanceCallback;
import com.codecomputerlove.problemshared.shared.callbacks.OpportunityCallback;
import com.codecomputerlove.problemshared.shared.callbacks.OpportunityListCallback;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

public class MockApiImpl implements Api {

    final Gson gson;

    @Inject
    public MockApiImpl(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void getAllOpportunities(OpportunityListCallback callback) {
        String response = getJsonStringFromFile("getOpportunities.json");

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
    public void getDistance(double longitude, double latitude, String oppName, DistanceCallback distanceCallback) {

    }

    @Override
    public void getOpportunity(String oppName, OpportunityCallback opportunityCallback) {

    }

    private String getJsonStringFromFile(String fileName) {
        String json = "";

        try {
            InputStream inputStream = AndroidApplication.getContext().getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }
}
