package com.codecomputerlove.problemshared.shared;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.codecomputerlove.problemshared.BuildConfig;


/**
 * Created by flaviusmester on 24/06/15.
 */
public class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplication.getInstance().component().inject(this);
        if (BuildConfig.DEBUG) {  //this will wake up and unlock the phone when in debug mode
            KeyguardManager km = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
            KeyguardManager.KeyguardLock keyguardLock = km.newKeyguardLock("TAG");
            keyguardLock.disableKeyguard();
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        }
    }
}
