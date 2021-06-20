package com.alkemy.DisneyAPI.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import com.alkemy.DisneyAPI.model.Characters;
import com.alkemy.DisneyAPI.repository.CharacterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/characters")
@RestController
public class CharactersController {

    @Autowired
    private CharacterRepository characterRepository;

    @GetMapping()
    public Optional<Iterable<Characters>> getAll(){
        return characterRepository.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Characters> findById(@PathVariable("id") Integer characterId){
        return characterRepository.findById(characterId);
    }
    
    @GetMapping(params="name")
    public Iterable<Characters> findByName(@RequestParam("name") String name){
        return characterRepository.findByName(name);
    }
    
    @GetMapping(params="age")
    public Iterable<Characters> findByAge(@RequestParam("age") Integer age){
        return characterRepository.findByAge(age);
    }
    @GetMapping(params="weight")
    public Iterable<Characters> findByWeight(@RequestParam("weight") Integer weight){
        return characterRepository.findByWeight(weight);
    }
    
    @DeleteMapping(path = "delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        try {
            characterRepository.deleteById(id);
            return "Character was deleted id: " + id;
        } catch (Exception e) {
            return "Character cannot deleted id: " + id;
        }
    }
    
    @PostMapping("save")
    public Characters save(@RequestParam("file") MultipartFile image, @ModelAttribute Characters character){

        if(!image.isEmpty()){

            Path imagesPath = Paths.get("src//main//resources//static//images");
            String absolutPath = imagesPath.toFile().getAbsolutePath();
            try {
                byte[] bytes = image.getBytes();
                Path route = Paths.get(absolutPath + image.getOriginalFilename());
                Files.write(route, bytes);
                character.setImage(image.getOriginalFilename());

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return characterRepository.save(character);
    }
    
}
