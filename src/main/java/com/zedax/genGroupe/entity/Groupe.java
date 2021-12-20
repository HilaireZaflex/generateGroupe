package com.zedax.genGroupe.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private int nombre;
    @ManyToMany(mappedBy = "groupes")
    private List<Admin> admin;
    @OneToMany(mappedBy = "groupe")
    private List<Apprenant> apprenants;
    @ManyToOne
    private Travaux travaux;

    public Groupe() {
    }

    public Travaux getTravaux() {
        return travaux;
    }

    public void setTravaux(Travaux travaux) {
        this.travaux = travaux;
    }

    public List<Apprenant> getApprenants() {
        return apprenants;
    }

    public void setApprenants(List<Apprenant> apprenants) {
        this.apprenants = apprenants;
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

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public List<Admin> getAdmin() {
        return admin;
    }

    public void setAdmin(List<Admin> admin) {
        this.admin = admin;
    }
}
