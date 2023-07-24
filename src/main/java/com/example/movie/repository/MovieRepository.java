package com.example.movie.repository;
import com.example.movie.model.Movie;

import java.util.ArrayList;

public interface MovieRepository {
    ArrayList<Movie>getMovies();

    Movie getMovieById(int movieId);
    Movie addMovie(Movie movie);
    Movie updatedMovie(int movieId,Movie updatemovie);
    void deleteMovie(int movieId);

}