package com.example.movie.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
 import org.springframework.web.server.ResponseStatusException;
 import org.springframework.http.HttpStatus;
import java.util.*;

import com.example.movie.model.Movie;

import com.example.movie.service.MovieH2Service;


@RestController
class MovieController {
    @Autowired
    public MovieH2Service movieService;


    @GetMapping("/movies")
    public ArrayList<Movie> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable int movieId) {
        Movie movie = movieService.getMovieById(movieId);
        if (movie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return movie;
    }
     @PostMapping("/movies")
     public Movie addMovie(@RequestBody Movie movie){
return movieService.addMovie(movie);
     }   

     @PutMapping("/movies/{movieId}")
    public Movie updatedMovie(@PathVariable int movieId, @RequestBody Movie updatemovie) {
        Movie movie = movieService.getMovieById(movieId);
        if (movie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return movieService.updatedMovie(movieId, updatemovie);
    }
     @DeleteMapping("/movies/{movieId}")
     public void deleteMovie(@PathVariable("movieId")int movieId){
        movieService.deleteMovie(movieId);
     }
}