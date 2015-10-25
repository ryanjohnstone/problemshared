package com.codecomputerlove.problemshared.module.pager.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.TabLayoutOnPageChangeListener;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.widget.TableLayout;
import android.widget.Toolbar;

import com.codecomputerlove.problemshared.R;
import com.codecomputerlove.problemshared.module.main.view.MainActivity;
import com.codecomputerlove.problemshared.module.pager.presenter.PagerPresenter;
import com.codecomputerlove.problemshared.shared.AndroidApplication;
import com.codecomputerlove.problemshared.shared.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PagerActivity extends BaseActivity {

    @Inject
    public PagerPresenter presenter;

    @InjectView(R.id.viewpager)
    ViewPager mViewPager;
    @InjectView(R.id.sliding_tabs)
    TabLayout mTabLayout;
    public boolean refresh = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplication.getInstance().component().inject(this);
        setContentView(R.layout.activity_pager);

        ButterKnife.inject(this);


        mViewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(),
                PagerActivity.this));
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("List");

        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tab.getPosition()) {
                    case 0:
                        mViewPager.setCurrentItem(0);
                        actionBar.setTitle("List");
                        break;
                    case 1:
                        mViewPager.setCurrentItem(1);
                        actionBar.setTitle("Profile");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


}
