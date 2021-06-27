package com.alkemy.DisneyAPI.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "characters")
public class Characters {
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Id
        private Integer pk_characterid;
        private String name;
        private String image;
        private Integer age;
        private Integer weight;
        private String history;
        @JsonManagedReference
        @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinTable(name = "characters_movies",
        joinColumns = {
                @JoinColumn(name = "pk_characterid", nullable = false)},
        inverseJoinColumns = {
                @JoinColumn(name = "pk_movieid", nullable = false)})
        private List<Movies> filmsID;
}