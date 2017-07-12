package com.somaznasi.hannesv.perceptionradio.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

import com.somaznasi.hannesv.perceptionradio.Activity.MainActivity;
import com.somaznasi.hannesv.perceptionradio.Holders.StationViewHolder;
import com.somaznasi.hannesv.perceptionradio.Model.Station;
import com.somaznasi.hannesv.perceptionradio.R;

import java.util.ArrayList;

/**
 * Created by hannesv on 2017/07/06.
 */

public class StationsAdapter extends RecyclerView.Adapter<StationViewHolder> {

    private ArrayList<Station> stations;

    public StationsAdapter(ArrayList<Station> stations) {
        this.stations = stations;
    }

    @Override
    public void onBindViewHolder(StationViewHolder holder, final int position) {
        final Station station = stations.get(position);
        holder.updateUI(station);

        final int p = position;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Load the detail screen
                MainActivity.getMainActivity().loadDetailScreen(station);

            }
        });

    }

    @Override
    public int getItemCount() {
        return stations.size();
    }

    @Override
    public StationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View stationCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_station, parent, false);
        return new StationViewHolder(stationCard);
    }
}
