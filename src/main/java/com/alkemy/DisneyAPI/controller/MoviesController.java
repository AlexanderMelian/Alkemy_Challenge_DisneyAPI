package com.alkemy.DisneyAPI.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import com.alkemy.DisneyAPI.model.Movies;
import com.alkemy.DisneyAPI.services.MoviesServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/movies")
@RestController
public class MoviesController {
    
    @Autowired
    private MoviesServices moviesServices;

    @GetMapping()
    public Iterable<Movies> findAll(){
        return moviesServices.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Movies> findById(@PathVariable("id") Integer id){
        return moviesServices.findById(id);
    }
    
    @GetMapping(params="name")
    public Iterable<Movies> findByTitle(@RequestParam("name") String title){
        return moviesServices.findByTitle(title);
    }
    @GetMapping(params="order")
    public Iterable<Movies> getByOrder(@RequestParam("order") String order){
        return getByOrder(order);
    }
    
    @DeleteMapping(path = "delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        try {
            moviesServices.delete(id);
            return "Character was deleted id: " + id;
        } catch (Exception e) {
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
        return moviesServices.save(movies);
    }
}