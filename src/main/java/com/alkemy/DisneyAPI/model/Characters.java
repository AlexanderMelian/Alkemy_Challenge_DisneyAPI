package com.alkemy.DisneyAPI.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name = "Characters")
public class Characters {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private int PK_characterID;
    private String name;
    private String image;
    private Integer age;
    private Integer weight;
    private String history;
    private ArrayList<Integer> filmsID = new ArrayList<>();


    public Characters(){
    }

    public Characters(String name, String image, Integer age, Integer weight, String history, ArrayList<Integer> filmId) {
        this.image = image;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.history = history;
        this.filmsID = filmId;
    }

    public int getPK_characterID() {
        return PK_characterID;
    }

    public void setPK_characterID(int PK_characterID) {
        this.PK_characterID = PK_characterID;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public ArrayList<Integer> getFilmsID() {
        return filmsID;
    }

    public void setFilmsID(ArrayList<Integer> filmsID) {
        this.filmsID = filmsID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Characters that = (Characters) o;
        return PK_characterID == that.PK_characterID && Objects.equals(name, that.name) && Objects.equals(image, that.image) && Objects.equals(age, that.age) && Objects.equals(weight, that.weight) && Objects.equals(history, that.history) && Objects.equals(filmsID, that.filmsID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PK_characterID, name, image, age, weight, history, filmsID);
    }

    @Override
    public String toString() {
        return "Characters{" +
                "PK_characterID=" + PK_characterID +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", history='" + history + '\'' +
                ", filmsID=" + filmsID +
                '}';
    }
}
