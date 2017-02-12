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
import android.widget.TextView;
import android.widget.Toast;

import com.example.hii.doctorconnect.R;

import java.util.List;

/**
 * Created by hii on 11/14/2016.
 */

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.MyViewHolder> {

    private Context mContext;
    private List<Appointment> appointmentList;
    String buttonTitle;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView doctorName, hospitalName,date,day,time;
        Button action;
      //  public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            doctorName = (TextView) view.findViewById(R.id.doctor_name);
            hospitalName = (TextView) view.findViewById(R.id.hospital_name);
            date = (TextView) view.findViewById(R.id.date);
            day = (TextView) view.findViewById(R.id.day);
            time = (TextView) view.findViewById(R.id.time);
            action= (Button) view.findViewById(R.id.button_action);
            //   thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
         //   overflow = (ImageView) view.findViewById(overflow);
        }
    }


    public AppointmentAdapter(Context mContext, List<Appointment> appointmentList,String buttonTitle) {
        this.mContext = mContext;
        this.appointmentList=appointmentList;
        this.buttonTitle=buttonTitle;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_appointment, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Appointment appointment = appointmentList.get(position);
        holder.doctorName.setText("Doctor Name: "+appointment.getDoctorName());
        holder.hospitalName.setText("Hospital Name: "+appointment.getHospitalName());
        holder.date.setText("Date: "+appointment.getDate());
        holder.day.setText("Day: "+appointment.getDay());
        holder.time.setText("Time: "+appointment.getTime());
        holder.action.setText(buttonTitle);

        // loading album cover using Glide library
       // Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        holder.action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), appointmentList.get(position).getDoctorName().toString(), Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return appointmentList.size();
    }
}