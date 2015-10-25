package com.codecomputerlove.problemshared.module.pager.view.fragments;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.codecomputerlove.problemshared.R;
import com.codecomputerlove.problemshared.models.ToggleButton;
import com.codecomputerlove.problemshared.models.ToggleButtonPink;
import com.codecomputerlove.problemshared.module.pager.view.PagerActivity;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ProfileFragment extends Fragment {

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

    @InjectView(R.id.saveSkills)
    Button saveSkills;
    @InjectView(R.id.saveCats)
    Button saveCats;

    ArrayList<ToggleButton> buttons = new ArrayList<>();
    ArrayList<ToggleButtonPink> pinkButtons = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.inject(this, view);

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

        pinkButtons.add(generalCharity);
        pinkButtons.add(disabled);
        pinkButtons.add(elderly);
        pinkButtons.add(education);
        pinkButtons.add(homeless);
        pinkButtons.add(religion);
        pinkButtons.add(youngPeople);
        pinkButtons.add(animals);
        pinkButtons.add(cubs);
        pinkButtons.add(art);

        saveSkills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String skillPrefs = "";
                for (ToggleButton button : buttons) {
                    if (button.getIsToggled()) {
                        skillPrefs += button.getText() + ",";
                    }
                }

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("skills", skillPrefs);
                editor.apply();

                new AlertDialog.Builder(getActivity())
                        .setTitle("Saved")
                        .setMessage("Skills have been successfully saved")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();

                ((PagerActivity) getActivity()).refresh = true;
            }
        });

        saveCats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String catPrefs = "";
                for (ToggleButtonPink button : pinkButtons) {
                    if (button.getIsToggled()) {
                        catPrefs += button.getText() + ",";
                    }
                }

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("categories", catPrefs);
                editor.apply();

                new AlertDialog.Builder(getActivity())
                        .setTitle("Saved")
                        .setMessage("Categories have been successfully saved")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();

                ((PagerActivity) getActivity()).refresh = true;
            }
        });

        loadPrefs();

        return view;
    }


    private void loadPrefs() {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String cats = sharedPref.getString("categories", "all");
        String skills = sharedPref.getString("skills","all");

        String[] skillsSep = skills.split(",");
        for (String skill : skillsSep) {
            if (skill.length()>0) {
                for (ToggleButton button : buttons) {
                    if (((String)button.getText()).equalsIgnoreCase(skill)) {
                        button.toggleOn();
                    }
                }
            }
        }

        String[] catsSep = cats.split(",");
        for (String cat : catsSep) {
            if (cat.length()>0) {
                for (ToggleButtonPink button : pinkButtons) {

                    if (((String)button.getText()).equalsIgnoreCase(cat)) {
                        button.toggleOn();
                    }
                }
            }
        }


    }
}
