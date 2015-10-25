package com.codecomputerlove.problemshared.module.detail.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.codecomputerlove.problemshared.R;
import com.codecomputerlove.problemshared.models.Opportunity;
import com.codecomputerlove.problemshared.shared.BaseActivity;
import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ShareActivity extends BaseActivity {

    private Opportunity mOpportunity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        mOpportunity = (Opportunity)getIntent().getSerializableExtra("opportunity");
    }

    public void share(View view) throws UnsupportedEncodingException {
        FacebookSdk.sdkInitialize(getApplicationContext());
        final ShareDialog shareDialog = new ShareDialog(this);

        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("http://aproblemshared.com/opportunity/" + URLEncoder.encode(mOpportunity.getOpportunityName(), "utf-8").replace("+", "%20")))
                .setContentTitle(mOpportunity.getOpportunityName())
                .setContentDescription("I'm volunteering at " + mOpportunity.getOpportunityName() + ", why don't you join me? A problem shared is a problem halved.")
                .build();

        shareDialog.show(content);
    }

    public void fullDetails(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("opportunity",mOpportunity);
        startActivity(intent);

    }
}
