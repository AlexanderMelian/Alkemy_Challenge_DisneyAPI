package com.alkemy.DisneyAPI.repository;

import java.util.Optional;

import com.alkemy.DisneyAPI.model.Genders;
import org.springframework.data.repository.CrudRepository;


public interface GendersRepository extends CrudRepository<Genders, Integer> {
    public Optional<Genders> findById(Integer id);
    public Genders getById(Integer genderId);
    
}
