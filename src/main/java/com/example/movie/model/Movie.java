package com.example.movie.model;

public class Movie {
    private int movieId;
    private String movieName;
    private String leadActor;

    public Movie(int movieId, String movieName,String leadActor) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.leadActor= leadActor;
    }

    public int getmovieId() {
        return movieId;
    }

    public void setmovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getmovieName() {
        return movieName;
    }

    public void setmovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getleadActor() {
        return leadActor;
    }

    public void setleadActor(String leadActor) {
        this.leadActor = leadActor;
    }
   
}