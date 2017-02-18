package com.example.hii.doctorconnect.Doctor;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.hii.doctorconnect.Patient.PatientPublicProfileFragment;
import com.example.hii.doctorconnect.R;

import java.util.List;

/**
 * Created by hii on 2/16/2017.
 */

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.MyViewHolder> {

    private Context mContext;
    private List<Patient> patientList;
    String buttonTitle,buttonTitle2;
    FragmentManager fragmentManager;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView doctorName, hospitalName,date,day,time;
        public TextView title, count;
        public ImageView thumbnail, overflow;
        RatingBar ratingBar;

        Button action,action1;
        //  public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            action= (Button) view.findViewById(R.id.button_action);
            action1= (Button) view.findViewById(R.id.button_action1);
            ratingBar=(RatingBar)view.findViewById(R.id.ratingBar);
        }
    }


    public PatientAdapter(Context mContext, List<Patient> patientList,String buttonTitle,String ButtonTitle2,FragmentManager fragmentManager) {
        this.mContext = mContext;
        this.patientList =patientList;
        this.buttonTitle=buttonTitle;
        this.buttonTitle2=ButtonTitle2;
        this.fragmentManager=fragmentManager;
    }

    @Override
    public PatientAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_patient, parent, false);

        return new PatientAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PatientAdapter.MyViewHolder holder, final int position) {
        Patient patient = patientList.get(position);

        holder.title.setText("Patient Name: "+patient.getPatientName());
        holder.action.setText(buttonTitle);
        holder.action1.setText(buttonTitle2);
        holder.ratingBar.setRating(patient.getRating());
        // loading album cover using Glide library
        Glide.with(mContext).load(patient.getThumbnail()).into(holder.thumbnail);

//        holder.overflow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showPopupMenu(holder.overflow);
//            }
//        });

//        holder.doctorName.setText("Doctor Name: "+doctor.getDoctorName());
//        holder.hospitalName.setText("Hospital Name: "+doctor.getHospitalName());
//        holder.action.setText(buttonTitle);

        // loading album cover using Glide library
        // Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        holder.action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), patientList.get(position).getPatientName().toString(), Toast.LENGTH_SHORT).show();
                showPopupMenu(holder.action);
                fragmentManager.beginTransaction().replace(R.id.frame,new PatientPublicProfileFragment()).commit();
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new PatientAdapter.MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Block", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }
}
