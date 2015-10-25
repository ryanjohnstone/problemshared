package com.codecomputerlove.problemshared.module;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.codecomputerlove.problemshared.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void launchSkills(View view) {
        Intent intent = new Intent(this, SkillsActivity.class);
        startActivity(intent);
    }
}
