package com.zedax.genGroupe.entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("VEILLE")
public class Veille extends Travaux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Veille() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
