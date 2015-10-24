package com.codecomputerlove.problemshared;

import android.graphics.drawable.ColorDrawable;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.internal.util.Checks;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

/**
 * Created by ryanjohnstone on 26/06/15.
 */
public class SharedMatchers {

    public static Matcher<View> withBackgroundColor(final int color) {
        Checks.checkNotNull(color);
        return new BoundedMatcher<View, View>(View.class) {
            @Override
            public boolean matchesSafely(View view) {
                return color == ((ColorDrawable) view.getBackground()).getColor();
            }
            @Override
            public void describeTo(Description description) {
                description.appendText("with background color: ");
            }
        };
    }
}
