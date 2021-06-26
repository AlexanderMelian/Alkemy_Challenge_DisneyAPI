package com.alkemy.DisneyAPI.services;

import java.util.ArrayList;
import java.util.Optional;

import com.alkemy.DisneyAPI.model.Movies;
import com.alkemy.DisneyAPI.repository.MoviesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoviesServices {
    @Autowired
    private MoviesRepository movieRepository;


    public Iterable<Movies> findAll(){
        return movieRepository.findAll();
    }

    public Optional<Movies> findById(Integer id){
        return movieRepository.findById(id);
    }
    public Movies save(Movies movie)
    {
        return movieRepository.save(movie);
    }
    public Iterable<Movies> findByTitle(String title){
        return movieRepository.findByTitle(title);
    }

    public ArrayList<Movies> getByOrder(String order){
        if(order.equals("ASC")){
            return (ArrayList<Movies>) movieRepository.getAllByOrderASC();            
        }else if(order.equals("DESC")){
            return (ArrayList<Movies>) movieRepository.getAllByOrderDESC();  
        }else{
            return (ArrayList<Movies>) movieRepository.findAll();
        }
    }
    
    public boolean delete(Integer id){
        try{
            movieRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
        
    }


}
