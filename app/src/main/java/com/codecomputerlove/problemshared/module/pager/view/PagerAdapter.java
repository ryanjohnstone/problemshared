package com.codecomputerlove.problemshared.module.pager.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import com.codecomputerlove.problemshared.R;
import com.codecomputerlove.problemshared.module.pager.view.fragments.MapFragment;
import com.codecomputerlove.problemshared.module.pager.view.fragments.OpportunityListFragment;
import com.codecomputerlove.problemshared.module.pager.view.fragments.ProfileFragment;

public class PagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private int[] imageResId = {
            R.drawable.ic_list_24dp,
            R.drawable.ic_profile_24dp
    };
    public String tabTitles[] = new String[] { "LIST", "PROFILE" };
    private Context context;

    public PagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new OpportunityListFragment();
        } else if (position == 1) {
            return new MapFragment();
        }

        return new ProfileFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Drawable image = ContextCompat.getDrawable(context, imageResId[position]);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        SpannableString sb = new SpannableString(" ");
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }


}
