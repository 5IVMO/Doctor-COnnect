package com.example.hii.doctorconnect.Patient;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hii on 11/13/2016.
 */
public class PatientAppointmentViewPagerAdapter extends FragmentStatePagerAdapter {
    String[] mTitles;

    public PatientAppointmentViewPagerAdapter(FragmentManager fm, int NumOfTabs, String[] titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PatientCurrentAppointmentFragment();
            case 1:
                return new PatientPendingAppointmentFragment();
            case 2:
                return new PatientPreviousAppointmentFragment();
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

