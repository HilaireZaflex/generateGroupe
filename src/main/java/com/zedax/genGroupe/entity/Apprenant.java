package com.zedax.genGroupe.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
public class Apprenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomComplet;
    private String email;
    private int tel;


    @ManyToMany(mappedBy = "apprenants")
    @JsonIgnore
    private List<Groupe> groupes;

    @ManyToOne
    private Promotion promotion;

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Apprenant() {
    }

    public List<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(List<Groupe> groupes) {
        this.groupes = groupes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
}
