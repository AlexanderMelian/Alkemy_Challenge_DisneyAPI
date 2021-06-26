package com.alkemy.DisneyAPI.repository;

import java.util.List;
import java.util.Optional;

import com.alkemy.DisneyAPI.model.Characters;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CharacterRepository extends CrudRepository<Characters, Integer>{

    public Optional<Iterable<Characters>> findByName(String name);

    public Optional<Iterable<Characters>> findByAge(Integer age);

    public Optional<Iterable<Characters>> findByWeight(Integer weight);

    @Query(value = "select * from characters" ,nativeQuery = true)
    public Optional<Iterable<Characters>> getAll();

    public List<Characters> findByfilmsID(String movie);

}