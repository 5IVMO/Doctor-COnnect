package com.example.hii.doctorconnect.Patient;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hii.doctorconnect.Doctor.DoctorFavouriteViewPagerAdapter;
import com.example.hii.doctorconnect.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PatientFavouriteFragment extends Fragment {


    public PatientFavouriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_patient_favourite, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);

        String[] titles = {"Approved","Pending"};
        DoctorFavouriteViewPagerAdapter adapter = new DoctorFavouriteViewPagerAdapter(getActivity().getSupportFragmentManager(),titles.length,titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

}
