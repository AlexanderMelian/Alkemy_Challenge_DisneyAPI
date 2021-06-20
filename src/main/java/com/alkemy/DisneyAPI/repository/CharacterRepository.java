package com.alkemy.DisneyAPI.repository;

import java.util.Optional;

import com.alkemy.DisneyAPI.model.Characters;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CharacterRepository extends CrudRepository<Characters, Integer>{

    public Iterable<Characters> findByName(String name);

    public Iterable<Characters> findByAge(Integer age);

    public Iterable<Characters> findByWeight(Integer weight);

    /*
    @Query(value = "SELECT name,image FROM characters;",nativeQuery = true)
    public Iterable<Characters> findAll(Integer characterId);
    */

    @Query(value = "select * from characters" ,nativeQuery = true)
    public Optional<Iterable<Characters>> getAll();
}