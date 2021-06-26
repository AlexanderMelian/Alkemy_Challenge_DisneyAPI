package com.alkemy.DisneyAPI.services;

/*
import java.util.ArrayList;
import java.util.List;
*/

import com.alkemy.DisneyAPI.model.Genders;
//import com.alkemy.DisneyAPI.model.Movies;
import com.alkemy.DisneyAPI.repository.GendersRepository;
//import com.alkemy.DisneyAPI.repository.MoviesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GendersServices{
    
    @Autowired
    private GendersRepository gendersRepository;

    //@Autowired
    //private MoviesRepository movieRepository;
    
    public Genders save(Genders gender){
        return gendersRepository.save(gender);       
    }
    /*public Iterable<Movies> getMoviesByGenreId(Integer genderId){
        Genders gender = gendersRepository.getById(genderId);
        ArrayList<Movies> movies = new ArrayList<>();

        if(gender != null){    
        List<Integer> moviesId = gender.getMoviesId();   

            for (Integer movieId : moviesId) {
                Movies movie = movieRepository.getById(movieId);
                if(movie != null){
                    movies.add(movie);                        
                }
            }
        }
        return movies;
    }
    */
}
