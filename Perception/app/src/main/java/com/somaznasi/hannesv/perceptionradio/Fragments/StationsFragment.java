package com.somaznasi.hannesv.perceptionradio.Fragments;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.somaznasi.hannesv.perceptionradio.Adapters.StationsAdapter;
import com.somaznasi.hannesv.perceptionradio.R;
import com.somaznasi.hannesv.perceptionradio.Services.DataService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StationsFragment extends Fragment {

    private static final String ARG_STATION_TYPE = "station_type";



    public static final int STATION_TYPE_FEATURED = 0;
    public static final int STATION_TYPE_RECENT = 1;
    public static final int STATION_TYPE_PARTY = 2;

    private int stationType;


    public StationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param stationType The Radio Stations Type.

     * @return A new instance of fragment StationsFragment.
     */

    public static StationsFragment newInstance(int stationType) {
        StationsFragment fragment = new StationsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STATION_TYPE, stationType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stationType = getArguments().getInt(ARG_STATION_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_stations,container,false);

        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recycler_stations);
        recyclerView.setHasFixedSize(true);

//       StationsAdapter adapter = new StationsAdapter();
//

        StationsAdapter adapter;

        if (stationType == STATION_TYPE_FEATURED) {
            adapter = new StationsAdapter(DataService.getInstance().getFeaturedStations());
        } else if (stationType == STATION_TYPE_RECENT){
            adapter = new StationsAdapter(DataService.getInstance().getFeaturedStations());
        } else {
            adapter = new StationsAdapter(DataService.getInstance().getFeaturedStations());
        }

        recyclerView.addItemDecoration(new HorizontalSpaceItemDecorator(30));

        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_stations, container, false);

        return v;
    }

}

class HorizontalSpaceItemDecorator extends RecyclerView.ItemDecoration {

    private final int spacer;

    public HorizontalSpaceItemDecorator(int spacer) {
        this.spacer = spacer;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.right = spacer;
    }
}