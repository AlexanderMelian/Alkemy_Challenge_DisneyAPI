package com.alkemy.DisneyAPI.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import com.alkemy.DisneyAPI.model.Movies;
import com.alkemy.DisneyAPI.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/movies")
@RestController
public class MoviesController {
    
    @Autowired
    private MovieRepository moviesRepository;

    @GetMapping()
    public Optional<Iterable<Movies>> getAll(){
        return moviesRepository.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Movies> findById(@PathVariable("id") Integer id){
        return moviesRepository.findById(id);
    }
    
    @GetMapping(params="name")
    public Iterable<Movies> findByName(@RequestParam("name") String name){
        return moviesRepository.findByName(name);
    }
    /*
    @DeleteMapping(path = "delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        try {
            moviesRepository.deleteById(id);
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
        return moviesRepository.save(movies);
    }
*/

}
