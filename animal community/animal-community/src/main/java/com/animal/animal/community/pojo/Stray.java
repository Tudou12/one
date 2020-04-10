package com.animal.animal.community.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "stray_animal")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Stray {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    int ID;

    @ManyToOne
    @JoinColumn(name="aid")
    private Category category;

    String animalName;
    String animalNo;
    String animalType;
    String animalDetail;
    String animalImage;

    public String getAnimalImage() {
        return animalImage;
    }

    public void setAnimalImage(String animalImage) {
        this.animalImage = animalImage;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalNo() {
        return animalNo;
    }

    public void setAnimalNo(String animalNo) {
        this.animalNo = animalNo;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalDetail() {
        return animalDetail;
    }

    public void setAnimalDetail(String animalDetail) {
        this.animalDetail = animalDetail;
    }
}