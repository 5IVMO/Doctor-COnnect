package com.example.hii.doctorconnect.Doctor;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hii.doctorconnect.R;

import java.util.List;

/**
 * Created by hii on 2/16/2017.
 */

public class StatusAdapter  extends RecyclerView.Adapter<StatusAdapter.MyViewHolder> {
    private Context mContext;
    private List<Status> statusList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView doctorName, hospitalName,date,day,time;
        public TextView title, count;
        public ImageView thumbnail, overflow;
        SwitchCompat hsp_switch;

        Button action,action1;
        //  public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);

            hospitalName=(TextView)itemView.findViewById(R.id.name);
            hsp_switch=(SwitchCompat)itemView.findViewById(R.id.hsp_switch);

        }
    }


    public StatusAdapter(Context mContext, List<Status> statusList) {
        this.mContext = mContext;
        this.statusList =statusList;

    }

    @Override
    public StatusAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_status, parent, false);

        return new StatusAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final StatusAdapter.MyViewHolder holder, final int position) {
        Status status= statusList.get(position);


        holder.hospitalName.setText(status.getHospitalName());
        holder.hsp_switch.setChecked(status.isStatus());
        holder.hsp_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                holder.hsp_switch.setChecked(isChecked);
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
        popup.setOnMenuItemClickListener(new StatusAdapter.MyMenuItemClickListener());
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
        return statusList.size();
    }
}

