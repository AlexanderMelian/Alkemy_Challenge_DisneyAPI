package com.alkemy.DisneyAPI.repository;

import com.alkemy.DisneyAPI.model.Genders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface GendersRepository extends CrudRepository<Genders, Integer> {
    public abstract Genders getByName(String name);
    public abstract Genders getById(Integer genderId);

    @Query(value = "SELECT * FROM genders", nativeQuery = true)
    public ArrayList<Object[]> getAll();
}
