package com.alkemy.DisneyAPI.model;




import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Genders")
public class Genders {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Integer PK_genderID;
    private String name;
    private String image;
    private ArrayList<Integer> moviesID = new ArrayList<>();

    public Genders(){

    }
    public Genders(String name, String image, ArrayList<Integer> moviesID){
        this.name = name;
        this.image = image;
        this.moviesID = moviesID;
    }

    public Integer getPK_genderID() {
        return PK_genderID;
    }

    public void setPK_genderID(Integer PK_genderID) {
        this.PK_genderID = PK_genderID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<Integer> getMoviesId() {
        return moviesID;
    }

    public void setMoviesId(ArrayList<Integer> moviesId) {
        this.moviesID = moviesId;
    }
}
