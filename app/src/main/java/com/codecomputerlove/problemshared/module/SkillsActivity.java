package com.codecomputerlove.problemshared.module;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.codecomputerlove.problemshared.R;
import com.codecomputerlove.problemshared.models.ToggleButton;

import java.util.ArrayList;
import java.util.prefs.Preferences;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SkillsActivity extends AppCompatActivity {

    @InjectView(R.id.heavy_lifting)
    ToggleButton heavyLifting;
    @InjectView(R.id.catering)
    ToggleButton catering;
    @InjectView(R.id.driving)
    ToggleButton driving;
    @InjectView(R.id.diy)
    ToggleButton diy;
    @InjectView(R.id.gardening)
    ToggleButton gardening;
    @InjectView(R.id.cleaning)
    ToggleButton cleaning;
    @InjectView(R.id.teaching)
    ToggleButton teaching;
    @InjectView(R.id.fundraising)
    ToggleButton fundraising;
    @InjectView(R.id.care_work)
    ToggleButton careWork;
    @InjectView(R.id.legal_work)
    ToggleButton legalWork;

    ArrayList<ToggleButton> buttons = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);
        ButterKnife.inject(this);

        buttons.add(heavyLifting);
        buttons.add(catering);
        buttons.add(driving);
        buttons.add(diy);
        buttons.add(gardening);
        buttons.add(cleaning);
        buttons.add(teaching);
        buttons.add(fundraising);
        buttons.add(careWork);
        buttons.add(legalWork);
    }

    public void launchCats(View view) {
        String prefs = "";
        for (ToggleButton button : buttons) {
            if (button.getIsToggled()) {
                prefs += button.getText() + ",";
            }
        }

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("skills",prefs);
        editor.apply();

        Intent intent = new Intent(this, CategoriesActivity.class);
        startActivity(intent);
    }
}
