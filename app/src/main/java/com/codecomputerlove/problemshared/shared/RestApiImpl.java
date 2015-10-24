package com.codecomputerlove.problemshared.shared;

import com.codecomputerlove.problemshared.shared.callbacks.StringCallback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.prefs.Preferences;

import javax.inject.Inject;

public class RestApiImpl implements RestApi{

    public OkHttpClient client;

    @Inject
    public RestApiImpl(OkHttpClient client) {
        this.client = client;
    }

    @Override
    public void get(String url, final StringCallback callback) {

        if(url == null || url.isEmpty()) {
            callback.onError(new Exception("invalid url"));
            return;
        }

        Request request = new Request.Builder()
                .url(url)
                .build();

        this.client.newCall(request).enqueue(new com.squareup.okhttp.Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callback.onError(e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.code()>= 200 && response.code() < 300) {
                    callback.onCompleted(response.body().string());
                } else {
                    callback.onError(new Exception("Response was not in the 200 range."));
                }
            }
        });

    }

}
