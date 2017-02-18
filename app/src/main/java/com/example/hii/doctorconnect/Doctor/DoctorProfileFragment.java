package com.example.hii.doctorconnect.Doctor;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hii.doctorconnect.R;

import java.io.ByteArrayOutputStream;

/**
 * A simple {@link Fragment} subclass.
 */
public class DoctorProfileFragment extends Fragment {


    EditText firstname, lastname, email, contact, dob, nic, hospital, specialization, location;
    ImageView image;
    TextView add_specialization, add_hsptal ,change_image;
    Button save, cancel;
    Context context;
    private final int IMAGE_RESULT= 202;

    public DoctorProfileFragment() {
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_doctor_profile, container, false);
    }


    public void init(){

        context=getContext();
        image=(ImageView)getView().findViewById(R.id.doctor_img);
      //  image.setImageResource(R.mipmap.ic_launcher);
        firstname=(EditText) getView().findViewById(R.id.doc_firstname);
        lastname=(EditText) getView().findViewById(R.id.doc_lastname);
        email=(EditText) getView().findViewById(R.id.doc_email);
        location=(EditText) getView().findViewById(R.id.doc_loc);
        contact=(EditText) getView().findViewById(R.id.doc_contct);
        dob=(EditText) getView().findViewById(R.id.doc_dob);
        nic=(EditText) getView().findViewById(R.id.doc_nic);
        hospital=(EditText) getView().findViewById(R.id.doc_hsptl);
        specialization=(EditText) getView().findViewById(R.id.doc_spec);
        save=(Button) getView().findViewById(R.id.save);
        cancel=(Button) getView().findViewById(R.id.cancel);
        add_specialization=(TextView)getView().findViewById(R.id.add_spec);
        add_hsptal=(TextView)getView().findViewById(R.id.add_hsptl);
      //  change_image=(TextView)getView().findViewById(R.id.chng_img);


        add_specialization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog=new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_add_specialization);
                Button save=(Button)dialog.findViewById(R.id.OK);
                Button cancel=(Button)dialog.findViewById(R.id.cancel);
                dialog.show();

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //api hit add specialization to doctor profile
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setCanceledOnTouchOutside(false);

            }
        });

        add_hsptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog=new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_add_hospital);
                Button save=(Button)dialog.findViewById(R.id.OK);
                Button cancel=(Button)dialog.findViewById(R.id.cancel);
                dialog.show();

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //api hit add specialization to doctor profile
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setCanceledOnTouchOutside(false);

            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(i, IMAGE_RESULT);
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(check()){
                    // params every thing
                    //api hit update doctor profile
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == IMAGE_RESULT && resultCode == Activity.RESULT_OK) {

            Uri uri = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getActivity().getContentResolver().query(uri,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            try {

                Bitmap bitmaps = MediaStore.Images.Media.getBitmap(getActivity().getApplicationContext().getContentResolver(), uri);

                final ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmaps.compress(Bitmap.CompressFormat.PNG, 90, stream);
                byte[] byteArray = stream.toByteArray();

                String encodeded = Base64.encodeToString(byteArray, Base64.DEFAULT);

                byte[] decodedString = Base64.decode(encodeded, Base64.DEFAULT);
                Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                image.setImageBitmap(bitmaps);
                // image.setImageBitmap(BitmapFactory.decodeFile(picturePath));

            } catch (Exception e) {
                e.printStackTrace();
            }



        }
    }


    public boolean check(){
        if(firstname.getText().toString().equals("")){
            firstname.setError("required");
            return false;
        }

        if(lastname.getText().toString().equals("")){
            lastname.setError("required");
            return false;
        }
        if(email.getText().toString().equals("")){
            email.setError("required");
            return false;
        }
        if(contact.getText().toString().equals("")){
            contact.setError("required");
            return false;
        }
        if(location.getText().toString().equals("")){
            location.setError("required");
            return false;
        }
        if(dob.getText().toString().equals("")){
            dob.setError("required");
            return false;
        }

        if(hospital.getText().toString().equals("")){
            hospital.setError("required");
            return false;
        }

        return true;
    }



}
