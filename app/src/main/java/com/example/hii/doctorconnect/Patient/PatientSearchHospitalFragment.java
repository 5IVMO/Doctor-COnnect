package com.example.hii.doctorconnect.Patient;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hii.doctorconnect.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PatientSearchHospitalFragment extends Fragment {


    public PatientSearchHospitalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_patient_search_hospital, container, false);
        return view;
    }

}
