package com.example.marmitonwish.jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String firstname;


    String mdp;

    public User() {
    }

    public User(String name, String firstname, String mdp, String email, String photo) {
        this.name = name;
        this.firstname = firstname;
        this.mdp = mdp;
        this.email = email;
        this.photo = photo;
    }

    String email;

    String photo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @OneToMany(mappedBy = "user")
    List<CookedRecipe> cookedRecipes;

}
