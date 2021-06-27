package com.alkemy.DisneyAPI.services;

import java.util.List;
import java.util.Optional;

import com.alkemy.DisneyAPI.model.Genders;
import com.alkemy.DisneyAPI.model.Movies;
import com.alkemy.DisneyAPI.repository.GendersRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GendersServices{
    
    @Autowired
    private GendersRepository gendersRepository;

    public Genders save(Genders gender){
        return gendersRepository.save(gender);       
    }
    public boolean delete(Integer id){
        try{
            gendersRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
        
    }
    public Optional<Genders> findById(Integer genderId) {
        return gendersRepository.findById(genderId);
    }
    public List<Movies> getMoviesByGenreId(Integer genreId) {
        Genders gender = gendersRepository.getById(genreId);
        if(gender != null){
            List<Movies> movies = gender.getMoviesID();   
            return movies;
        }else{
            return null;
        }

    }

}