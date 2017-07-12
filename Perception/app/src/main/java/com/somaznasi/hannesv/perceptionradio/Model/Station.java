package com.somaznasi.hannesv.perceptionradio.Model;

/**
 * Created by hannesv on 2017/07/06.
 */

public class Station {


    final String DRAWABLE = "drawable/";
    private String stationTitle;
    //path
    private String imgUri;

    public Station(String stationTitle, String imgUri) {
        this.stationTitle = stationTitle;
        this.imgUri = imgUri;
    }

    public String getStationTitle() {
        return stationTitle;
    }

    public String getImgUri() {

        return DRAWABLE + imgUri;
    }

}
