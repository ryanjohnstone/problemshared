package com.codecomputerlove.problemshared.acceptance;

import com.codecomputerlove.problemshared.R;
import com.codecomputerlove.problemshared.module.main.view.MainActivity;
import com.codecomputerlove.problemshared.shared.InjectedBaseActivityTest;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Created by flaviusmester on 24/06/15.
 */
public class MainActivityTest extends InjectedBaseActivityTest {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testMainSuccess() {
        onView(withText(R.string.app_name)).check(matches(isDisplayed()));
    }
}