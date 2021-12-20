package com.zedax.genGroupe.entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("TP")
public class Tp extends Travaux{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Tp() {
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
