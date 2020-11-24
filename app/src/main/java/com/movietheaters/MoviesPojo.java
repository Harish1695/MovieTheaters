package com.movietheaters;

import com.google.gson.annotations.SerializedName;

public class MoviesPojo {


    public MoviesPojo(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    @SerializedName("movie_name")
    private String movie_name;


    public MoviesPojo()
    {

    }
}



