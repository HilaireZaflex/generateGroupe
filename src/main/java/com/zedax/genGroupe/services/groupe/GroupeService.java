package com.zedax.genGroupe.services.groupe;

import java.util.List;

import com.zedax.genGroupe.entity.Groupe;

public interface GroupeService {
    
    public String addGroupe(Groupe groupe);
    public List<Groupe> getAllGroupes();
    public Groupe getGroupeById(Long groupeId);
    public void modifyGroupe(Long groupeId, Groupe groupe);
    public String deleteGroupe(Long groupeId);    

    public List<Groupe> generateGroupesByNbGroupes(Integer nombreGroupe);

}
