package com.alkemy.DisneyAPI.service;

import com.alkemy.DisneyAPI.model.Characters;
import com.alkemy.DisneyAPI.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CharactersService{

    @Autowired
    private CharacterRepository characterRepository;


    public ArrayList<Object[]> getAll(){
        return characterRepository.getAll();
    }
    public Characters getById(Integer characterId){
        return characterRepository.getById(characterId);
    }
    public Characters save(Characters character){
        return characterRepository.save(character);
    }
    public Characters getByName(String name){
        return characterRepository.getByName(name);
    }

    public Characters getByAge(Integer age){
        return characterRepository.getByAge(age);
    }
    public Characters getByWeight(Integer weight){
        return characterRepository.getByWeight(weight);
    }

    public boolean delete(Integer id){
        try{
            characterRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }

    }


}
