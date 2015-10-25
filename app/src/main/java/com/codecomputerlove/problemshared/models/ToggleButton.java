package com.codecomputerlove.problemshared.models;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.codecomputerlove.problemshared.R;

public class ToggleButton extends Button {

    private boolean toggledOn;

    public ToggleButton(Context context) {
        super(context);
    }

    public ToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ToggleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ToggleButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);

        if (pressed) {
            if (toggledOn) {
                this.setBackground(getResources().getDrawable(R.color.button_background));
                this.setTextColor(getResources().getColor(R.color.ps_blue));
            } else {
                this.setBackground(getResources().getDrawable(R.color.ps_blue));
                this.setTextColor(getResources().getColor(R.color.background));
            }

            toggledOn = !toggledOn;
        }
    }

    public boolean getIsToggled() {
        return toggledOn;
    }

    public void toggleOn() {
        this.setBackground(getResources().getDrawable(R.color.ps_blue));
        this.setTextColor(getResources().getColor(R.color.background));
        toggledOn = true;
    }

    public void toggleOff() {
        this.setBackground(getResources().getDrawable(R.color.button_background));
        this.setTextColor(getResources().getColor(R.color.ps_blue));
        toggledOn = false;
    }
}
