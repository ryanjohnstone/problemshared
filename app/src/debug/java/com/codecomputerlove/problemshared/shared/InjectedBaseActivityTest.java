package com.codecomputerlove.problemshared.shared;

import android.test.ActivityInstrumentationTestCase2;

import com.codecomputerlove.problemshared.module.main.presenter.MainPresenter;

import javax.inject.Inject;

/**
 * Created by flaviusmester on 24/06/15.
 */
public class InjectedBaseActivityTest extends ActivityInstrumentationTestCase2<BaseActivity> {

    @Inject
    MainPresenter mainPresenter;

    public MainPresenter getMainPresenter() {
        return mainPresenter;
    }

    public InjectedBaseActivityTest(Class activityClass) {
        super(activityClass);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        AndroidApplication app = (AndroidApplication) getInstrumentation().getTargetContext().getApplicationContext();
        app.setMockMode(true);
        app.component().inject(this);
    }

    @Override
    protected void tearDown() throws Exception {
        AndroidApplication app = (AndroidApplication) getInstrumentation().getTargetContext().getApplicationContext();
        app.setMockMode(false);
    }
}