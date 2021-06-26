package com.alkemy.DisneyAPI.repository;

import java.util.ArrayList;
import java.util.Optional;

import com.alkemy.DisneyAPI.model.Movies;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends CrudRepository<Movies, Integer> {

    public Iterable<Movies> findByTitle(String title);

    public Optional<Movies> findById(Integer id);

    //tiene que devolver -> imagen, titulo y fecha de creacion
    @Query(value = "select * from movies" ,nativeQuery = true)
    public Optional<Iterable<Movies>> getAll();

    @Query(value = "SELECT * FROM movies ORDER BY creation_date ASC",nativeQuery = true)
    public Iterable<Movies> getAllByOrderASC();

    @Query(value = "SELECT * FROM movies ORDER BY creation_date DESC",nativeQuery = true)
    public ArrayList<Movies> getAllByOrderDESC();

    public Movies getById(Integer movieId);
}