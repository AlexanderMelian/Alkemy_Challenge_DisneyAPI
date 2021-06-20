package com.alkemy.DisneyAPI.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

import javax.persistence.*;
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
        @JsonFormat(pattern="dd/MM/yyyy")
        private Date creation_date;
        private Integer rating;
        @ManyToMany(fetch=FetchType.LAZY,  mappedBy = "filmsID", cascade = CascadeType.ALL)
        private List<Characters> charactersID;
}
