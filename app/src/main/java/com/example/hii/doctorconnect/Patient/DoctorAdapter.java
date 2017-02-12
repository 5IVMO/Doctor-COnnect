package com.example.hii.doctorconnect.Patient;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.hii.doctorconnect.R;

import java.util.List;

/**
 * Created by hii on 11/16/2016.
 */

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.MyViewHolder> {

    private Context mContext;
    private List<Doctor> doctorList;
    String buttonTitle,buttonTitle2;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView doctorName, hospitalName,date,day,time;
        public TextView title, count,hospital,specialization;
        public ImageView thumbnail, overflow;

        Button action,action1;
        //  public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            hospital = (TextView) view.findViewById(R.id.hospital);
            specialization = (TextView) view.findViewById(R.id.specialization);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            action= (Button) view.findViewById(R.id.button_action);
            action1= (Button) view.findViewById(R.id.button_action1);
         //   overflow = (ImageView) view.findViewById(R.id.overflow);

//            doctorName = (TextView) view.findViewById(R.id.doctor_name);
//            hospitalName = (TextView) view.findViewById(R.id.hospital_name);
//            date = (TextView) view.findViewById(R.id.date);
//            day = (TextView) view.findViewById(R.id.day);
//            time = (TextView) view.findViewById(R.id.time);
//            action= (Button) view.findViewById(R.id.button_action);
            //   thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            //   overflow = (ImageView) view.findViewById(overflow);
        }
    }


    public DoctorAdapter(Context mContext, List<Doctor> doctorList,String buttonTitle,String ButtonTitle2) {
        this.mContext = mContext;
        this.doctorList =doctorList;
        this.buttonTitle=buttonTitle;
        this.buttonTitle2=ButtonTitle2;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_doctor, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Doctor doctor = doctorList.get(position);

        holder.title.setText("Doctor Name: "+doctor.getDoctorName());
        holder.hospital.setText("Hospital name: "+doctor.getHospitalName());
        holder.specialization.setText("Specialization:" +doctor.getSpecialization());
        holder.count.setText("Rating: "+doctor.getRating());
        holder.action.setText(buttonTitle);
        holder.action1.setText(buttonTitle2);
        // loading album cover using Glide library
        Glide.with(mContext).load(doctor.getThumbnail()).into(holder.thumbnail);

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
                Toast.makeText(view.getContext(), doctorList.get(position).getDoctorName().toString(), Toast.LENGTH_SHORT).show();
                showPopupMenu(holder.action);
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
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
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
        return doctorList.size();
    }
}