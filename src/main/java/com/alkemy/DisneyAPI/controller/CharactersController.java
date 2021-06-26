package com.alkemy.DisneyAPI.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import com.alkemy.DisneyAPI.model.Characters;
import com.alkemy.DisneyAPI.services.CharacterServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/characters")
@RestController
public class CharactersController {

    @Autowired
    private CharacterServices characterServices;

    @GetMapping()
    public Iterable<Characters> findAll(){
        return characterServices.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Characters> findById(@PathVariable("id") Integer characterId){
        return characterServices.findById(characterId);
    }
    
    @GetMapping(params="name")
    public Optional<Iterable<Characters>> findByName(@RequestParam("name") String name){
        return characterServices.findByName(name);
    }
    
    @GetMapping(params="age")
    public Optional<Iterable<Characters>> findByAge(@RequestParam("age") Integer age){
        return characterServices.findByAge(age);
    }
    
    @DeleteMapping(path = "delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        try {
            characterServices.delete(id);
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
        return characterServices.save(character);
    }
    
}
