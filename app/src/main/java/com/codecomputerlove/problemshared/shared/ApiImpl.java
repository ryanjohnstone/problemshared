package com.codecomputerlove.problemshared.shared;

import com.codecomputerlove.problemshared.models.Opportunity;
import com.codecomputerlove.problemshared.shared.callbacks.DistanceCallback;
import com.codecomputerlove.problemshared.shared.callbacks.OpportunityListCallback;
import com.codecomputerlove.problemshared.shared.callbacks.StringCallback;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.List;

import javax.inject.Inject;

public class ApiImpl implements Api {

    RestApi restApi;
    final Gson gson;

    static final String ALL_OPPORTUNITIES_URL = "http://aproblemsharedapi.apphb.com/opportunities/skills/all/categories/all";
    static final String DISTANCE_URL = "http://aproblemsharedapi.apphb.com/location/";

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

    @Override
    public void getDistance(double longitude, double latitude, String oppName, final DistanceCallback distanceCallback) {
        try {
            String url = DISTANCE_URL+"lon/"+longitude+"/lat/"+latitude+"/name/"+ URLEncoder.encode(oppName, "utf-8").replace("+", "%20");
            restApi.get(url, new StringCallback() {
                @Override
                public void onCompleted(String response) {
                    try {
                        JSONObject distanceObject = new JSONObject(response);
                        JSONArray rows = distanceObject.getJSONArray("rows");
                        JSONArray elements = ((JSONObject) rows.get(0)).getJSONArray("elements");
                        String text =  ((JSONObject)elements.get(0)).getJSONObject("distance").getString("text");
                        distanceCallback.onCompleted(text);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onError(Exception error) {

                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
