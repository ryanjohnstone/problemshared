package com.codecomputerlove.problemshared.module.pager.view.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codecomputerlove.problemshared.R;
import com.codecomputerlove.problemshared.models.Opportunity;
import com.codecomputerlove.problemshared.module.pager.view.OpportunityListAdapter;
import com.codecomputerlove.problemshared.module.pager.view.PagerActivity;
import com.codecomputerlove.problemshared.shared.callbacks.OpportunityListCallback;

import java.util.ArrayList;
import java.util.List;

public class OpportunityListFragment extends Fragment {

    List<Opportunity> mOpportunities = new ArrayList<>();
    Handler mHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opportunity_list, container, false);

        RecyclerView rv = (RecyclerView)view.findViewById(R.id.recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        final OpportunityListAdapter adapter = new OpportunityListAdapter(mOpportunities);
        rv.setAdapter(adapter);

        mHandler = new Handler();

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String cats = sharedPref.getString("categories", "all");
        String skills = sharedPref.getString("skills","all");

        ((PagerActivity) getActivity()).presenter.getOpportunitiesBySkillsAndCategories(skills,cats,new OpportunityListCallback() {
            @Override
            public void onCompleted(final List<Opportunity> response) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        adapter.updateItems(response);

                    }
                });

            }

            @Override
            public void onError(Exception error) {

            }
        });

        return view;
    }

}
