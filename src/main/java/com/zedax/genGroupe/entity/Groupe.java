package com.zedax.genGroupe.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;


    @ManyToMany
    private List<Apprenant> apprenants;

    public List<Apprenant> getApprenants() {
        return apprenants;
    }

    public void setApprenants(List<Apprenant> apprenants) {
        this.apprenants = apprenants;
    }

    public Groupe() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


}
