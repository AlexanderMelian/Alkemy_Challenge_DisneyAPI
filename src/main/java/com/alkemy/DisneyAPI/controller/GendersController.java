package com.alkemy.DisneyAPI.controller;


import com.alkemy.DisneyAPI.model.Genders;
import com.alkemy.DisneyAPI.repository.GendersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/genders")
@RestController
public class GendersController {

    @Autowired
    private GendersRepository gendersRepository;

    @GetMapping()
    public Iterable<Genders> findAll(){
        return gendersRepository.findAll();
    }
    /*
    @PostMapping("save")
    public Genders save(@RequestParam("file") MultipartFile image, @ModelAttribute Genders gender){
        if(!image.isEmpty()){
            Path imagesPath = Paths.get("src//main//resources//static//images");
            String absolutPath = imagesPath.toFile().getAbsolutePath();
            try {
                byte[] bytes = image.getBytes();
                Path route = Paths.get(absolutPath + image.getOriginalFilename());
                Files.write(route, bytes);
                gender.setImage(image.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return gendersService.save(gender);
    }

    @GetMapping("/{id}")
    public Genders getById(@PathVariable("id") Integer genderId){
        return gendersService.getById(genderId);
    }

    @GetMapping(params = "name")
    public Genders getByName(@RequestParam("name") String name){
        return gendersService.getByName(name);
    }

    @DeleteMapping(path = "delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        if(gendersService.delete(id)){
            return "Gender was deleted id: " + id ;
        }else{
            return "Gender cannot deleted id:" + id;
        }
    }
    */
}
