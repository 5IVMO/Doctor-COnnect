package com.example.hii.doctorconnect;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hii.doctorconnect.Doctor.DoctorHomeActivity;
import com.example.hii.doctorconnect.Doctor.DoctorSignUpFragment;
import com.example.hii.doctorconnect.Patient.PatientHomeActivity;
import com.example.hii.doctorconnect.Patient.PatientSignUpFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    EditText editTextEmail,editTextUserPassWord;
    Button mLogin;
    TextView textViewSignUp;
    Dialog dialog;
    Button Doctor,Patient,Cancel;
    AppPreferences appPreferences;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_login, container, false);
        appPreferences=new AppPreferences(getActivity());
        editTextEmail= (EditText) view.findViewById(R.id.editText_Email);
        editTextUserPassWord= (EditText) view.findViewById(R.id.editText_UserPassword);
        mLogin= (Button) view.findViewById(R.id.button_login);
        mLogin.setOnClickListener(this);
        textViewSignUp= (TextView) view.findViewById(R.id.signUp_text);
        textViewSignUp.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button_login:

                if(editTextEmail.getText().toString().equals("patient")){
                    //if Patient
                    appPreferences.saveUserID("1");
                    appPreferences.saveUserType(editTextEmail.getText().toString());
                    Intent intent = new Intent(getActivity(),PatientHomeActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
                if(editTextEmail.getText().toString().equals("doctor")){
                    //if Doctor
                    appPreferences.saveUserID("2");
                    appPreferences.saveUserType(editTextEmail.getText().toString());
                    Intent intent = new Intent(getActivity(),DoctorHomeActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }

                break;
            case R.id.signUp_text:
                dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_signup_option);
              //  dialog.setTitle(Html.fromHtml("<font color='#008080'>Sign Up</font>"));
                dialog.show();
                //Button
                Doctor = (Button) dialog.findViewById(R.id.button_doctor);
                Patient= (Button) dialog.findViewById(R.id.button_patient);
                Cancel= (Button) dialog.findViewById(R.id.button_cancel);
                Doctor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container1,new DoctorSignUpFragment()).addToBackStack("Tag").commit();
                    }
                });
                Patient.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container1,new PatientSignUpFragment()).addToBackStack("Tag").commit();
                    }
                });
                Cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                break;
        }
    }
}
