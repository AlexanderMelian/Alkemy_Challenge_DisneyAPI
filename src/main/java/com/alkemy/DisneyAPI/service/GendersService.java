package com.alkemy.DisneyAPI.service;

import com.alkemy.DisneyAPI.model.Genders;
import com.alkemy.DisneyAPI.repository.GendersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GendersService {

    @Autowired
    private GendersRepository gendersRepository;

    public ArrayList<Object[]> getAll(){
        return gendersRepository.getAll();
    }

    public Genders getById(Integer genderId){
        return gendersRepository.getById(genderId);
    }

    public Genders getByName(String name) {
         return gendersRepository.getByName(name);
    }

    public Genders save(Genders gender){
        return gendersRepository.save(gender);
    }

    public boolean delete(Integer id){
        try{
            gendersRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

}
