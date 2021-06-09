package com.alkemy.DisneyAPI.controller;

import com.alkemy.DisneyAPI.model.Characters;
import com.alkemy.DisneyAPI.service.CharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

@RequestMapping("/characters")
@RestController
public class CharactersController {

    @Autowired
    private CharactersService characterService;

    @GetMapping()
    public ArrayList<Object[]> getAll(){
        return characterService.getAll();
    }

    @GetMapping("/{id}")
    public Characters getById(@PathVariable("id") Integer characterId){
        return characterService.getById(characterId);
    }

    @GetMapping(params="name")
    public Characters getByName(@RequestParam("name") String name){
        return characterService.getByName(name);
    }
    @GetMapping(params="age")
    public Characters getByAge(@RequestParam("age") Integer age){
        return characterService.getByAge(age);
    }
    @GetMapping(params="weight")
    public Characters getByWeight(@RequestParam("weight") Integer weight){
        return characterService.getByWeight(weight);
    }

    @DeleteMapping(path = "delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        if(characterService.delete(id)){
            return "Character was deleted id: " + id;
        }
        else{
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

        return characterService.save(character);
    }

}
