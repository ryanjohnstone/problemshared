package com.codecomputerlove.problemshared.module.detail.view;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codecomputerlove.problemshared.R;
import com.codecomputerlove.problemshared.models.Opportunity;
import com.codecomputerlove.problemshared.module.detail.presenter.DetailPresenter;
import com.codecomputerlove.problemshared.shared.AndroidApplication;
import com.codecomputerlove.problemshared.shared.BaseActivity;
import com.codecomputerlove.problemshared.shared.callbacks.DistanceCallback;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DetailActivity extends BaseActivity {

    Opportunity mOpportunity;

    @Inject
    public DetailPresenter presenter;

    @InjectView(R.id.opportunity_name)
    TextView mOpportunityNameTextView;
    @InjectView(R.id.charity_name)
    TextView mCharityNameTextView;
    @InjectView(R.id.opportunity_description)
    TextView mOpportunityDescriptionTextView;

    @InjectView(R.id.days)
    TextView mDaysTextView;

    @InjectView(R.id.distance)
    TextView mDistanceTextView;

    @InjectView(R.id.contact_layout)
    LinearLayout mContactLayout;
    @InjectView(R.id.contact_text)
    TextView mContactTextView;
    @InjectView(R.id.text_button)
    Button mTextButton;

    @InjectView(R.id.address_layout)
    LinearLayout mAddressLayout;
    @InjectView(R.id.address)
    TextView mAddressText;
    @InjectView(R.id.directions_button)
    Button mDirectionsButton;

    @InjectView(R.id.website_layout)
    LinearLayout mWebsiteLayout;
    @InjectView(R.id.website_url)
    TextView mWebsiteTextView;

    @InjectView(R.id.facebook_layout)
    LinearLayout mFacebookLayout;
    @InjectView(R.id.facebook_url)
    TextView mFacebookTextView;

    @InjectView(R.id.twitter_layout)
    LinearLayout mTwitterLayout;
    @InjectView(R.id.twitter_url)
    TextView mTwitterTextView;

    @InjectView(R.id.youtube_layout)
    LinearLayout mYoutubeLayout;
    @InjectView(R.id.youtube_url)
    TextView mYoutubeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        AndroidApplication.getInstance().component().inject(this);
        ButterKnife.inject(this);

        getSupportActionBar().setTitle("Detail");

        mOpportunity = (Opportunity)getIntent().getSerializableExtra("opportunity");

        mOpportunityNameTextView.setText(mOpportunity.getOpportunityName());
        mOpportunityDescriptionTextView.setText(mOpportunity.getActivities());
        mCharityNameTextView.setText(mOpportunity.getCharity());

        mDaysTextView.setText(mOpportunity.getmTimeOfActivity());

        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();

        final Handler mHandler = new Handler();

        presenter.getDistance(longitude,latitude, mOpportunity.getOpportunityName(), new DistanceCallback(){

            @Override
            public void onCompleted(final String response) {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        mDistanceTextView.setText(response);

                    }
                });
            }

            @Override
            public void onError(Exception error) {

            }
        });

        final Context context = this;

        if (mOpportunity.getTelephone().equals("0")) {
            mContactLayout.setVisibility(View.GONE);
        } else {
            String contactName = "";
            if (mOpportunity.getContactName().equals("0")) {
                mContactTextView.setText(String.format(getString(R.string.contact_message), "the organiser"));
                mTextButton.setText(String.format(getString(R.string.contact_button_message),"Organiser"));
            } else {
                contactName = mOpportunity.getContactName();
                mContactTextView.setText(String.format(getString(R.string.contact_message), mOpportunity.getContactName()));
                mTextButton.setText(String.format(getString(R.string.contact_button_message),mOpportunity.getContactName()));
            }

            final String finalContactName = contactName;
            mTextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                    smsIntent.setData(Uri.parse("sms:"));
                    smsIntent.putExtra("address", mOpportunity.getTelephone());
                    smsIntent.putExtra("sms_body","Hi "+ finalContactName +", I'm really interested in coming along and lending a hand.");
                    startActivity(smsIntent);
                }
            });
        }

        if (mAddressText.equals("0")) {
            mAddressLayout.setVisibility(View.GONE);
        } else {
            mAddressText.setText(mOpportunity.getAddress());
            mDirectionsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + mOpportunity.getAddress());
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    context.startActivity(mapIntent);
                }
            });
        }

        if (mOpportunity.getWebsite() != "0") {
            mWebsiteTextView.setText(mOpportunity.getWebsite());
            mWebsiteTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = mOpportunity.getWebsite();
                    if (!url.startsWith("http://") && !url.startsWith("https://")) url = "http://" + url;
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });
        } else {
            mWebsiteLayout.setVisibility(View.GONE);
        }

        if (mOpportunity.getFacebookAccountName() != "0") {
            mFacebookTextView.setText(mOpportunity.getFacebookAccountName());
            mFacebookTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = "http://facebook.com/"+mOpportunity.getFacebookAccountName();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });
        } else {
            mFacebookLayout.setVisibility(View.GONE);
        }

        if (mOpportunity.getTwitterAccountName() != "0") {
            mTwitterTextView.setText("@"+mOpportunity.getTwitterAccountName());
            mTwitterTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = "http://twitter.com/" + mOpportunity.getTwitterAccountName();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });
        } else {
            mTwitterLayout.setVisibility(View.GONE);
        }

        if (mOpportunity.getYoutubeAccountName() != "0") {
            mYoutubeTextView.setText(mOpportunity.getYoutubeAccountName());
            mYoutubeTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = "http://youtube.com/" + mOpportunity.getYoutubeAccountName();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });
        } else {
            mYoutubeLayout.setVisibility(View.GONE);
        }

    }
}
