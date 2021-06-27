package com.alkemy.DisneyAPI.services;

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
    public Iterable<Object[]> getAll(){
        return movieRepository.getAll();
    }

    public Optional<Movies> findById(Integer id){
        return movieRepository.findById(id);
    }
    public Movies save(Movies movie)
    {
        return movieRepository.save(movie);
    }
    public Iterable<Object[]> findByTitle(String title){
        return movieRepository.findByTitle(title);
    }

    public Iterable<Object[]> getByOrder(String order){
        if(order.equals("ASC")){
            return movieRepository.getAllByOrderASC();            
        }else if(order.equals("DESC")){
            return movieRepository.getAllByOrderDESC();  
        }else{
            return movieRepository.getAll();
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
