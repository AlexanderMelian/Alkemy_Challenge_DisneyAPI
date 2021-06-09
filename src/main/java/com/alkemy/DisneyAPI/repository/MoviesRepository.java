package com.alkemy.DisneyAPI.repository;

import com.alkemy.DisneyAPI.model.Movies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface MoviesRepository extends CrudRepository<Movies, Integer> {
    public abstract Movies getByName(String name);
    public abstract Movies getByRating(Integer rating);
    public abstract Movies getById(Integer movieId);

    @Query(value = "SELECT * FROM movies", nativeQuery = true)
    public ArrayList<Object[]> getAll();
}
