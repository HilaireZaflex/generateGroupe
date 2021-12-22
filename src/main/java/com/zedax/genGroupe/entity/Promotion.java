package com.zedax.genGroupe.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Promotion {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String promoNom;
    private Date promoAnnee;

    @OneToMany(mappedBy = "promotion")
    private List<Apprenant> apprenants;


    public Promotion() {
    }

    public Long getId() {
        return id;
    }

    public List<Apprenant> getApprenants() {
        return apprenants;
    }

    public void setApprenants(List<Apprenant> apprenants) {
        this.apprenants = apprenants;
    }

    public String getPromoNom() {
        return promoNom;
    }

    public Date getPromoAnnee() {
        return promoAnnee;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPromoNom(String promoNom) {
        this.promoNom = promoNom;
    }

    public void setPromoAnnee(Date promoAnnee) {
        this.promoAnnee = promoAnnee;
    }
}
