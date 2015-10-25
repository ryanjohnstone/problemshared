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
import com.codecomputerlove.problemshared.models.ToggleButtonPink;
import com.codecomputerlove.problemshared.module.pager.view.PagerActivity;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CategoriesActivity extends AppCompatActivity {

    @InjectView(R.id.general_charity)
    ToggleButtonPink generalCharity;
    @InjectView(R.id.disabled)
    ToggleButtonPink disabled;
    @InjectView(R.id.elderly)
    ToggleButtonPink elderly;
    @InjectView(R.id.education)
    ToggleButtonPink education;
    @InjectView(R.id.homeless)
    ToggleButtonPink homeless;
    @InjectView(R.id.religion)
    ToggleButtonPink religion;
    @InjectView(R.id.young_people)
    ToggleButtonPink youngPeople;
    @InjectView(R.id.animals)
    ToggleButtonPink animals;
    @InjectView(R.id.cubs)
    ToggleButtonPink cubs;
    @InjectView(R.id.art)
    ToggleButtonPink art;

    ArrayList<ToggleButtonPink> buttons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        ButterKnife.inject(this);

        buttons.add(generalCharity);
        buttons.add(disabled);
        buttons.add(elderly);
        buttons.add(education);
        buttons.add(homeless);
        buttons.add(religion);
        buttons.add(youngPeople);
        buttons.add(animals);
        buttons.add(cubs);
        buttons.add(art);
    }

    public void launchList(View view) {
        String prefs = "";
        for (ToggleButtonPink button : buttons) {
            if (button.getIsToggled()) {
                prefs += button.getText() + ",";
            }
        }

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("categories",prefs);
        editor.apply();

        Intent intent = new Intent(this, PagerActivity.class);
        startActivity(intent);
    }
}
