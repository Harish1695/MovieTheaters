package com.movietheaters;

import com.google.gson.annotations.SerializedName;

public class TheatersPojo {

    public TheatersPojo(String theater_name) {
        this.theater_name = theater_name;
    }

    public String getTheater_name() {
        return theater_name;
    }

    public void setTheater_name(String theater_name) {
        this.theater_name = theater_name;
    }

    @SerializedName("theater_name")
    private String theater_name;


    public TheatersPojo()
    {

    }
}



