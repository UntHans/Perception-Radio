package com.somaznasi.hannesv.perceptionradio.Services;

import com.somaznasi.hannesv.perceptionradio.Model.Station;

import java.util.ArrayList;

/**
 * Created by hannesv on 2017/07/06.
 */

public class DataService
{
    private static final DataService ourInstance = new DataService();

    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService() {

    }

    public ArrayList<Station> getFeaturedStations() {
        //Pretend we just downloaded feutured stations from the Internet

        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Flight Plan (Tunes for travel)","flightplanmusic"));
        list.add(new Station("Two-Wheelin' (Biking Playlist","bicyclemusic"));
        list.add(new Station("Kids Jams (Music for kids)","kidsmusic"));

        return list;
    }

    public ArrayList<Station> getRecentStations() {

        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Vynyl Statoin (Feel the Rock and Roll)","vinylmusic"));
        list.add(new Station("Music You'll Like (Play and See)","socialmusic"));
        list.add(new Station("Unlock Your Dance (Pop and Lock)","keymusic"));
        return list;
    }

    public ArrayList<Station> getPartyStations() {

        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Flight Plan (Tunes for travel)","flightplanmusic"));
        list.add(new Station("Two-Wheelin' (Biking Playlist","bicyclemusic"));
        list.add(new Station("Kids Jams (Music for kids)","kidsmusic"));
        return list;
    }
}
