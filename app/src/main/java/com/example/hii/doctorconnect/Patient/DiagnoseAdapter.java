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
 * Created by hii on 1/8/2017.
 */

public class DiagnoseAdapter extends RecyclerView.Adapter<DiagnoseAdapter.MyViewHolder>{
    private Context mContext;
    private List<Diagnose> diagnoseList;
    String buttonTitle;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView medicineName,medicineCategory;
        Button action;
        //  public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);

            medicineName = (TextView) view.findViewById(R.id.name);
            medicineCategory = (TextView) view.findViewById(R.id.category);
            action= (Button) view.findViewById(R.id.button_diagnose_detail);
        }
    }


    public DiagnoseAdapter(Context mContext, List<Diagnose> diagnoseList) {
        this.mContext = mContext;
        this.diagnoseList = diagnoseList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_diagnose, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Diagnose diagnose = diagnoseList.get(position);

        holder.medicineName.setText("Medicine Name: "+diagnose.getMedicineName());
        holder.medicineCategory.setText("Medicine Category: "+diagnose.getMedicineCategory());

        holder.action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), diagnoseList.get(position).getMedicineName().toString(), Toast.LENGTH_SHORT).show();
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
        return diagnoseList.size();
    }
}
