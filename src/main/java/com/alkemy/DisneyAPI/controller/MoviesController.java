package com.alkemy.DisneyAPI.controller;


import com.alkemy.DisneyAPI.model.Movies;
import com.alkemy.DisneyAPI.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@RequestMapping("/movies")
@RestController
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping()
    public ArrayList<Object[]> getAll(){
        return moviesService.getAll();
    }

    @GetMapping("/{id}")
    public Movies getById(@PathVariable("id") Integer characterId){
        return moviesService.getById(characterId);
    }
    @GetMapping(params="name")
    public Movies getByName(@RequestParam("name") String name){
        return moviesService.getByName(name);
    }
    @GetMapping(params="name")
    public Movies getByRating(@RequestParam("rating") Integer rating){
        return moviesService.getByRating(rating);
    }

    @DeleteMapping(path = "delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        if(moviesService.delete(id)){
            return "Character was deleted id: " + id;
        }
        else{
            return "Character cannot deleted id: " + id;
        }
    }


    @PostMapping("save")
    public Movies save(@RequestParam("file") MultipartFile image, @ModelAttribute Movies movies){
        if(!image.isEmpty()){
            Path imagesPath = Paths.get("src//main//resources//static//images");
            String absolutPath = imagesPath.toFile().getAbsolutePath();
            try {
                byte[] bytes = image.getBytes();
                Path route = Paths.get(absolutPath + image.getOriginalFilename());
                Files.write(route, bytes);
                movies.setImage(image.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return moviesService.save(movies);
    }


}
