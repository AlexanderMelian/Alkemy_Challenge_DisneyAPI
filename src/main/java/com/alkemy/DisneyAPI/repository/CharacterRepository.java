package com.alkemy.DisneyAPI.repository;

import com.alkemy.DisneyAPI.model.Characters;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface CharacterRepository extends CrudRepository<Characters, Integer>{

    public abstract Characters getByName(String name);
    public abstract Characters getByAge(Integer age);
    public abstract Characters getByWeight(Integer weight);
    public abstract Characters getById(Integer characterId);


    @Query(value = "SELECT * FROM characters",nativeQuery = true)
    public ArrayList<Object[]> getAll();
}