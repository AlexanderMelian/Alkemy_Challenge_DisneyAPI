package com.alkemy.DisneyAPI.services;

import java.util.Optional;

import com.alkemy.DisneyAPI.model.Characters;
import com.alkemy.DisneyAPI.repository.CharacterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterServices {
    @Autowired
    private CharacterRepository characterRepository;
    
    public Iterable<Characters> findAll(){
        return characterRepository.findAll();
    }
    public Iterable<Object[]> getAll() {
        return characterRepository.getAll();
    }
    public Optional<Characters> findById(Integer characterId) {
        return characterRepository.findById(characterId);
    }
    public Iterable<Object[]> findByName(String name) {
        return characterRepository.findByName(name);
    }
    public Iterable<Object[]> findByAge(Integer age) {
        return characterRepository.findByAge(age);
    }

    public boolean delete(Integer id){
        try{
            characterRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
        
    }

    public Characters save(Characters character) {
        return characterRepository.save(character);
    }


}
