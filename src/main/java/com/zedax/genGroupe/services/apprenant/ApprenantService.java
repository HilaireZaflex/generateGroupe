package com.zedax.genGroupe.services.apprenant;

import com.zedax.genGroupe.entity.Apprenant;


import java.util.List;


public interface ApprenantService {
    public String addApprenant(Apprenant apprenant);
    public Apprenant  modifierApprenant(Apprenant apprenant, Long id);
    public void supprimerApprenant(Long id);
    public List<Apprenant> listerApprenant();
    public Apprenant AfficherById (Long id);

}
