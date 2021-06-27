package com.alkemy.DisneyAPI.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "movies")
public class Movies {
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Id
        private Integer pk_movieid;
        private String title;
        private String image;
        @JsonFormat(pattern="yyyy/MM/dd")
        private Date creation_date;
        private Integer rating;
        @JsonBackReference
        @ManyToMany(fetch=FetchType.LAZY,  mappedBy = "filmsID", cascade = CascadeType.ALL)
        private List<Characters> charactersID;

        @JsonBackReference
        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name="pk_genderid")
        private Genders gendersID;
}
