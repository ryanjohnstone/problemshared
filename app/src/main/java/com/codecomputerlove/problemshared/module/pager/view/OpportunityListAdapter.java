package com.codecomputerlove.problemshared.module.pager.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codecomputerlove.problemshared.R;
import com.codecomputerlove.problemshared.models.Opportunity;
import com.codecomputerlove.problemshared.module.detail.view.DetailActivity;

import java.util.List;

public class OpportunityListAdapter extends RecyclerView.Adapter<OpportunityListAdapter.OpportunityViewHolder> {

    List<Opportunity> mOpportunities;
    Context mContext;

    public OpportunityListAdapter(List<Opportunity> opportunities) {
        mOpportunities = opportunities;
    }

    @Override
    public OpportunityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.opportunity_item, parent, false);
        mContext = v.getContext();
        OpportunityViewHolder ovh = new OpportunityViewHolder(v);
        return ovh;
    }

    @Override
    public void onBindViewHolder(final OpportunityViewHolder holder, final int position) {
        holder.title.setText(mOpportunities.get(position).getOpportunityName());
        holder.charity.setText(mOpportunities.get(position).getCharity());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("opportunity",mOpportunities.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return mOpportunities.size();
    }

    public void updateItems(List<Opportunity> items) {
        mOpportunities = items;
        notifyDataSetChanged();
    }

    public static class OpportunityViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView title;
        TextView charity;
        TextView distance;

        OpportunityViewHolder(final View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            title = (TextView)itemView.findViewById(R.id.title);
            charity = (TextView)itemView.findViewById(R.id.charity);
            distance = (TextView)itemView.findViewById(R.id.distance);
        }
    }
}
