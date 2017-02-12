package com.example.hii.doctorconnect.Patient;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.hii.doctorconnect.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PatientSearchFragment extends Fragment {

    Spinner optionBySpinner,optionForSpinner;
    private RadioGroup radioTypeGroup;
    private RadioButton radioTypeButton, radioButtonDoctor, radioButtonHospital;
    String selectedType=" ";
    Button findButton;

    public PatientSearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_patient_search, container, false);
        initView(view);

        return view;
    }

    private void initView(final View view) {
        findButton= (Button) view.findViewById(R.id.button_find);
//        radioTypeGroup=(RadioGroup)view.findViewById(R.id.radioGroup);
//        radioButtonDoctor=(RadioButton)view.findViewById(R.id.radioButton_doctor);
//        radioButtonHospital=(RadioButton)view.findViewById(R.id.radioButton_hospital);
//        radioTypeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//              @Override
//              public void onCheckedChanged(RadioGroup group, int checkedId)
//                 {
//                 radioTypeButton = (RadioButton) view.findViewById(checkedId);
//                     selectedType=radioTypeButton.getText().toString();
//                      Toast.makeText(getActivity(),  selectedType, Toast.LENGTH_SHORT).show();
//                  }
//           }
//        );
        //Spinner
        optionForSpinner= (Spinner) view.findViewById(R.id.options1_spinner);
        optionBySpinner = (Spinner) view.findViewById(R.id.options_spinner);
        getSpinnerData();
        optionForSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                //String selectedCategory = String.valueOf(optionForSpinner.getSelectedItem());
                //Log.d("selected Category",selectedCategory);
               // getSpinnerData2();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        getSpinnerData2();
        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedType=String.valueOf(optionForSpinner.getSelectedItem());
                if(selectedType.equals("Doctor")){
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame,new PatientSearchDoctorFragment()).addToBackStack("Tag").commit();
                }
                else if(selectedType.equals("Hospital")){
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame,new PatientSearchHospitalFragment()).addToBackStack("Tag").commit();
                }
            }
        });
    }

    private void getSpinnerData() {
        List<String> optionList = new ArrayList<String>();
        optionList.add("By Name");
        optionList.add("By Specialization");

        ArrayAdapter<String> optionDataAdapter = new ArrayAdapter<String>
                (getActivity().getApplicationContext(), R.layout.spinner_item1,optionList);

        optionDataAdapter.setDropDownViewResource
                (R.layout.spinner_item);

        optionBySpinner.setAdapter(optionDataAdapter);
    }
    private void getSpinnerData2() {
        List<String> optionList = new ArrayList<String>();
        optionList.add("Doctor");
        optionList.add("Hospital");

        ArrayAdapter<String> optionDataAdapter = new ArrayAdapter<String>
                (getActivity().getApplicationContext(), R.layout.spinner_item1,optionList);

        optionDataAdapter.setDropDownViewResource
                (R.layout.spinner_item);

        optionForSpinner.setAdapter(optionDataAdapter);
    }

}
