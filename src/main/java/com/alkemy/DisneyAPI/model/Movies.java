package com.alkemy.DisneyAPI.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "Movies")
public class Movies {
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Id private Integer PK_movieID;
        private String title;
        private String image;
        @JsonFormat(pattern="dd/MM/yyyy")
        private Date creation_date;
        private Integer rating;
        private ArrayList<Integer> charactersID = new ArrayList<>();

        public Movies(){

        }
        public Movies(String title, String image, Date creation_date, Integer rating, ArrayList<Integer> charactersID){
                this.image = image;
                this.title = title;
                this.creation_date = creation_date;
                this.rating = rating;
                this.charactersID = charactersID;
        }

        public Integer getPK_movieID() {
                return PK_movieID;
        }

        public void setPK_movieID(Integer PK_movieID) {
                this.PK_movieID = PK_movieID;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getImage() {
                return image;
        }

        public void setImage(String image) {
                this.image = image;
        }

        public Date getCreation_date() {
                return creation_date;
        }

        public void setCreation_date(Date creation_date) {
                this.creation_date = creation_date;
        }

        public Integer getRating() {
                return rating;
        }

        public void setRating(Integer rating) {
                this.rating = rating;
        }

        public ArrayList<Integer> getCharactersID() {
                return charactersID;
        }

        public void setCharactersID(ArrayList<Integer> charactersID) {
                this.charactersID = charactersID;
        }
}
