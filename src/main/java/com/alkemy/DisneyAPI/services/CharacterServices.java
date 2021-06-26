package com.alkemy.DisneyAPI.services;

import java.util.List;
import java.util.Optional;

import com.alkemy.DisneyAPI.model.Characters;
import com.alkemy.DisneyAPI.repository.CharacterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterServices {
    @Autowired
    private CharacterRepository characterRepository;



    public List<Characters> findByfilmsID(String movie) throws Exception{
        try {
			List<Characters> characters = characterRepository.findByfilmsID(movie);
			return characters;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
    }

    
    public boolean delete(Integer id){
        try{
            characterRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
        
    }
    public Iterable<Characters> findAll(){
        return characterRepository.findAll();
    }
    public Optional<Characters> findById(Integer characterId) {
        return characterRepository.findById(characterId);
    }
    public Optional<Iterable<Characters>> findByName(String name) {
        return characterRepository.findByName(name);
    }
    public Optional<Iterable<Characters>> findByAge(Integer age) {
        return characterRepository.findByAge(age);
    }


    public Characters save(Characters character) {
        return characterRepository.save(character);
    }
}
