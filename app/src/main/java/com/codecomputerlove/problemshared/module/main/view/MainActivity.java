package com.codecomputerlove.problemshared.module.main.view;

import android.content.Intent;
import android.os.Bundle;

import com.codecomputerlove.problemshared.R;
import com.codecomputerlove.problemshared.module.main.presenter.MainPresenter;
import com.codecomputerlove.problemshared.module.pager.view.PagerActivity;
import com.codecomputerlove.problemshared.shared.AndroidApplication;
import com.codecomputerlove.problemshared.shared.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setElevation(0);
        setContentView(R.layout.activity_main);
        AndroidApplication.getInstance().component().inject(this);
        ButterKnife.inject(this);

        Intent intent = new Intent(this, PagerActivity.class);
        startActivity(intent);
        finish();
    }
}
