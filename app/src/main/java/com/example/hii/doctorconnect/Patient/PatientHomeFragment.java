package com.example.hii.doctorconnect.Patient;


import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hii.doctorconnect.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PatientHomeFragment extends Fragment {

    private RecyclerView recyclerView;
    //  private AlbumsAdapter adapter;
    //  private List<Album> albumList;

    private HomeAdapter adapter;
    private List<Home> messageList;


    public PatientHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_patient_home, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        //  albumList = new ArrayList<>();
        //  adapter = new AlbumsAdapter(getActivity(), albumList);

        messageList = new ArrayList<>();
        adapter=new HomeAdapter(getActivity(),messageList);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

        // RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

//        try {
//            Glide.with(this).load(R.drawable.cover).into((ImageView) view.findViewById(R.id.backdrop));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        return view;
    }
    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {

        Home a=new Home("Doctor Robert is online");
        messageList.add(a);

        Home b=new Home("You updated your profile");
        messageList.add(b);

        Home c=new Home("Doctor Python accepted your request");
        messageList.add(c);

        Home d=new Home("Doctor Rober is online");
        messageList.add(d);

        Home e=new Home("Doctor Rober is online");
        messageList.add(e);

        Home f=new Home("Doctor Rober is online");
        messageList.add(f);

        Home g=new Home("Doctor Rober is online");
        messageList.add(g);
        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
