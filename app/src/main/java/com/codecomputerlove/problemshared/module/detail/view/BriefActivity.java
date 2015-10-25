package com.codecomputerlove.problemshared.module.detail.view;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.codecomputerlove.problemshared.R;
import com.codecomputerlove.problemshared.models.Opportunity;
import com.codecomputerlove.problemshared.module.detail.presenter.DetailPresenter;
import com.codecomputerlove.problemshared.shared.AndroidApplication;
import com.codecomputerlove.problemshared.shared.BaseActivity;
import com.codecomputerlove.problemshared.shared.callbacks.DistanceCallback;
import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class BriefActivity extends BaseActivity {

    @Inject
    public DetailPresenter presenter;

    @InjectView(R.id.opportunity_name)
    TextView opportunityTextView;
    @InjectView(R.id.charity_name)
    TextView charityTextView;
    @InjectView(R.id.days)
    TextView daysTextView;
    @InjectView(R.id.distance)
    TextView distanceTextView;
    private Opportunity mOpportunity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brief);

        AndroidApplication.getInstance().component().inject(this);
        ButterKnife.inject(this);

        mOpportunity = (Opportunity)getIntent().getSerializableExtra("opportunity");
        opportunityTextView.setText(mOpportunity.getOpportunityName());
        charityTextView.setText(mOpportunity.getCharity());
        daysTextView.setText("Starts in "+mOpportunity.getmTimeOfActivity());

        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();

        final Handler mHandler = new Handler();

        presenter.getDistance(longitude, latitude, mOpportunity.getOpportunityName(), new DistanceCallback() {

            @Override
            public void onCompleted(final String response) {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        distanceTextView.setText(response);

                    }
                });
            }

            @Override
            public void onError(Exception error) {

            }
        });
    }

    public void share(View view) throws UnsupportedEncodingException {
        FacebookSdk.sdkInitialize(getApplicationContext());
        final ShareDialog shareDialog = new ShareDialog(this);

        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("http://aproblemshared.com/opportunity/" + URLEncoder.encode(mOpportunity.getOpportunityName(), "utf-8").replace("+", "%20")))
                .setContentTitle(mOpportunity.getOpportunityName())
                .setContentDescription("I'm volunteering at "+mOpportunity.getOpportunityName()+", why don't you join me? A problem shared is a problem halved.")
                .setImageUrl(Uri.parse(""))
                .build();

        shareDialog.show(content);
    }

    public void doThis(View view) {
        Intent intent = new Intent(this, ShareActivity.class);
        intent.putExtra("opportunity",mOpportunity);
        startActivity(intent);
    }
}
