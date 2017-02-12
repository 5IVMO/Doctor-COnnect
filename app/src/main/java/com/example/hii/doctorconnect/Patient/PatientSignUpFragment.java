package com.example.hii.doctorconnect.Patient;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.hii.doctorconnect.Doctor.DoctorHomeActivity;
import com.example.hii.doctorconnect.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PatientSignUpFragment extends Fragment {

    Button SignUp,login;
    Dialog dialog;
    EditText editText;
    public PatientSignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sign_up_patient, container, false);
        SignUp= (Button) view.findViewById(R.id.button_signUp);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_confirmation);
                // dialog.setTitle(Html.fromHtml("<font color='#008080'>Select Option</font>"));
                dialog.show();

                editText= (EditText) dialog.findViewById(R.id.editText_ConfirmationCode);
                //Button
                login= (Button) dialog.findViewById(R.id.button_login);
                login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(editText.getText().toString().equals("patient")){
                            //if Patient
                            Intent intent = new Intent(getActivity(),PatientHomeActivity.class);
                            startActivity(intent);
                            getActivity().finish();
                        }
                        if(editText.getText().toString().equals("doctor")){
                            //if Doctor
                            Intent intent = new Intent(getActivity(),DoctorHomeActivity.class);
                            startActivity(intent);
                            getActivity().finish();
                        }
                    }
                });
            }
        });
        return view;
    }
}
