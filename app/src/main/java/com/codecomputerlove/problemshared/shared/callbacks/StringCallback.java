package com.codecomputerlove.problemshared.shared.callbacks;

public interface StringCallback {
    void onCompleted(String response);
    void onError(Exception error);
}
