package com.animal.animal.community.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "adopter")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Adopter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

//    @ManyToOne
//    @JoinColumn(name = "ID")
//    private Stray Stray;

    String name;
    int age;
    String sex;
    String idCar;
    String adress;
    String animalId;
    String adressImage;
    String adopted;
    int phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public com.animal.animal.community.pojo.Stray getStray() {
//        return Stray;
//    }
//
//    public void setStray(com.animal.animal.community.pojo.Stray stray) {
//        Stray = stray;
//    }


    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }


    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    public String getAdressImage() {
        return adressImage;
    }

    public void setAdressImage(String adressImage) {
        this.adressImage = adressImage;
    }

    public String getAdopted() {
        return adopted;
    }

    public void setAdopted(String adopted) {
        this.adopted = adopted;
    }
}