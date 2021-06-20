package com.alkemy.DisneyAPI.model;




import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "Genders")
public class Genders {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Integer pk_genderid;
    private String name;
    private String image;
    //private ArrayList<Integer> moviesID = new ArrayList<>();
}
