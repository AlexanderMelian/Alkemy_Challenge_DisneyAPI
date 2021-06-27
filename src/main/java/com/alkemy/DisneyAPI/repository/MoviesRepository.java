package com.alkemy.DisneyAPI.repository;

import java.util.Optional;

import com.alkemy.DisneyAPI.model.Movies;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends CrudRepository<Movies, Integer> {

    public Iterable<Object[]> findByTitle(String title);

    public Optional<Movies> findById(Integer id);
    
    @Query(value = "SELECT title,image,creation_date FROM movies",nativeQuery = true)
    public Iterable<Object[]> getAll();

    @Query(value = "SELECT title,image,creation_date FROM movies ORDER BY creation_date ASC",nativeQuery = true)
    public Iterable<Object[]> getAllByOrderASC();

    @Query(value = "SELECT title,image,creation_date FROM movies ORDER BY creation_date DESC",nativeQuery = true)
    public Iterable<Object[]> getAllByOrderDESC();
    
    public Movies getById(Integer movieId);
}