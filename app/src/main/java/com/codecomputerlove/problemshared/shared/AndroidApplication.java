package com.codecomputerlove.problemshared.shared;

import android.app.Application;
import android.content.Context;

import com.codecomputerlove.problemshared.BuildConfig;
import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

/**
 * Created by ryanjohnstone on 19/06/15.
 */
public class AndroidApplication extends Application {

    AppComponent appComponent;
    private static AndroidApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        appComponent = AppComponent.Initializer.init(false);

        if (!BuildConfig.DEBUG) {
            Fabric.with(this, new Crashlytics());
        }
    }

    public static AndroidApplication getInstance() {
        return sInstance;
    }

    public static Context getContext() {
        return sInstance;
    }

    public void setMockMode(boolean useMock) {
        appComponent = AppComponent.Initializer.init(useMock);
    }

    public AppComponent component() {
        return appComponent;
    }


}
