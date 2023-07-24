package com.example.movie.service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.jdbc.core.JdbcTemplate;
 import org.springframework.stereotype.Service;
 import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import com.example.movie.repository.MovieRepository;
import com.example.movie.model.Movie;
import java.util.*;
import com.example.movie.model.MovieRowMapper;
@Service
public class MovieH2Service implements MovieRepository{
    @Autowired
    private JdbcTemplate db;
@Override
public ArrayList<Movie>getMovies(){
List<Movie>movieList=db.query("select * from MOVIELIST",new MovieRowMapper());
return new ArrayList<>(movieList);

}
@Override
public Movie getMovieById(int movieId){
    try{
Movie movie=db.queryForObject("select * from MOVIELIST where movieId = ?", new MovieRowMapper(),movieId);
          return movie;
       }catch (Exception e){
throw new ResponseStatusException(HttpStatus.NOT_FOUND);
}
}
@Override
public Movie addMovie(Movie movie){
    db.update("INSERT INTO MOVIELIST(movieName,leadActor)values(?,?)",movie.getmovieName(),movie.getleadActor());
   
    return getMovieById(movie.getmovieId());
}
@Override
public Movie updatedMovie(int movieId,Movie movie){
    if(movie.getmovieName()!=null){
        db.update("UPDATE MOVIELIST SET movieName=? WHERE movieId=?",movie.getmovieName(),movieId);
    }
    if(movie.getleadActor()!=null){
        db.update("UPDATE MOVIELIST SET leadActor=? WHERE movieId=?",movie.getleadActor(),movieId);
    }
    return getMovieById(movieId);
    }
@Override
public void deleteMovie(int movieId){
    db.update("DELETE FROM MOVIELIST WHERE movieId=?",movieId);
}
}