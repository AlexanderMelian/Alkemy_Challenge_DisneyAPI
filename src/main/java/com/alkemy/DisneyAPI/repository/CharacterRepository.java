package com.alkemy.DisneyAPI.repository;

import java.util.List;

import com.alkemy.DisneyAPI.model.Characters;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CharacterRepository extends CrudRepository<Characters, Integer>{

    public Iterable<Object[]> findByName(String name);

    public Iterable<Object[]> findByAge(Integer age);

    @Query(value = "select image,name from characters;" ,nativeQuery = true)
    public Iterable<Object[]> getAll();

    public List<Object[]> findByfilmsID(String movie);

}