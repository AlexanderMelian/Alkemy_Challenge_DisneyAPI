package com.alkemy.DisneyAPI.service;

import com.alkemy.DisneyAPI.model.Movies;
import com.alkemy.DisneyAPI.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MoviesService {
    @Autowired
    private MoviesRepository moviesRepository;

    public ArrayList<Object[]> getAll(){
        return moviesRepository.getAll();
    }
    public Movies getById(Integer characterId){
        return moviesRepository.getById(characterId);
    }

    public Movies save(Movies character){
        return moviesRepository.save(character);
    }

    public Movies getByName(String name){
        return moviesRepository.getByName(name);
    }

    public Movies getByRating(Integer rating){
        return moviesRepository.getByRating(rating);
    }

    public boolean delete(Integer id){
        try{
            moviesRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


}
