package com.alkemy.DisneyAPI.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "genders")
public class Genders {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer pk_genderid;
    private String name;
    private String image;

    @JsonManagedReference
    @OneToMany(mappedBy = "gendersID",fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Movies> moviesID;

}