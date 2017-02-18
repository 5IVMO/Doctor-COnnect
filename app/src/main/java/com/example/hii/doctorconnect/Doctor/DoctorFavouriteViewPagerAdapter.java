package com.example.hii.doctorconnect.Doctor;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hii on 2/16/2017.
 */

public class DoctorFavouriteViewPagerAdapter extends FragmentStatePagerAdapter {
    String[] mTitles;

    public DoctorFavouriteViewPagerAdapter(FragmentManager fm, int NumOfTabs, String[] titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new DoctorApprovedFavouriteFragment();
            case 1:
                return new DoctorPendingFavouriteFragment();
        }

        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }
}

