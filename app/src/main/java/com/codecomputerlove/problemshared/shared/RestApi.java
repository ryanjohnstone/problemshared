package com.codecomputerlove.problemshared.shared;

import com.codecomputerlove.problemshared.shared.callbacks.StringCallback;

public interface RestApi {

    void get(String url, StringCallback callback);
}
