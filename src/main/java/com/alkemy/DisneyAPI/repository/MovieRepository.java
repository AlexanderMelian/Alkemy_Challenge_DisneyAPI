package com.alkemy.DisneyAPI.repository;

import java.util.Optional;

import com.alkemy.DisneyAPI.model.Movies;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movies, Integer> {
    // @Repository
    // public interface CharacterRepository extends CrudRepository<Characters, Integer>{

    //public Iterable<Movies> findByName(String name);

    public Iterable<Movies> findByName(String name);

    @Query(value = "select * from characters" ,nativeQuery = true)
    public Optional<Iterable<Movies>> getAll();
}
